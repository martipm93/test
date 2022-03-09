package com.slashmobility.test.service.impl;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.slashmobility.test.entity.UserEntity;
import com.slashmobility.test.entity.VerificationTokenEntity;
import com.slashmobility.test.mapper.UserMapper;
import com.slashmobility.test.repository.UserRepository;
import com.slashmobility.test.service.UserService;
import com.slashmobility.test.service.VerificationTokenService;
import com.slashmobility.test.web.dto.UserDTO;
import com.slashmobility.test.web.dto.UserDetailsDTO;
import com.slashmobility.test.web.endpoint.constants.URLConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenService verificationTokenService;

    @Value("${spring.mail.username}")
    private String userNameFromMail;

    @Value("${spring.sendgrid.api-key}")
    private String sendGridApiKey;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder
                            , VerificationTokenService verificationTokenService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.verificationTokenService = verificationTokenService;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        UserEntity userEntity = userMapper.toEntity(userDTO);
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity.setEnabled(Boolean.FALSE);
        userEntity = userRepository.saveAndFlush(userEntity);

        VerificationTokenEntity verificationTokenEntity = verificationTokenService.create(userEntity);
        sendUserConfirmationMail(verificationTokenEntity.getToken(), userDTO);

        return userMapper.toDTO(userEntity);
    }

    @Override
    public UserDTO enableUser(String validationToken) {
        Optional<VerificationTokenEntity> verificationTokenEntity = verificationTokenService.findByToken(validationToken);
        if (verificationTokenEntity.isPresent()) {
            UserEntity userEntity = verificationTokenEntity.get().getUserEntity();
            userEntity.setEnabled(Boolean.TRUE);
            return userMapper.toDTO(userRepository.saveAndFlush(userEntity));
        } else {
            //throw Exception;
            return null;
        }
    }

    private UserDTO save(UserDTO userDto) {
        UserDetailsDTO userLogged = (UserDetailsDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userDto.setPassword(userLogged.getPassword());
        UserEntity userEntity = userMapper.toEntity(userDto);
        userEntity.setEnabled(Boolean.TRUE);
        return userMapper.toDTO(userRepository.saveAndFlush(userEntity));
    }

    @Override
    public UserDTO update(UserDTO userDTO, Long id) {
        if (findById(id) != null) {
            userDTO.setId(id);
            return save(userDTO);
        } else {
            //throw new Exception();
            return null;
        }
    }

    @Override
    public UserDTO resetPassword(String newPassword) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<UserEntity> userEntity = userRepository.findByUsernameEquals(authentication.getName());
        if (userEntity.isPresent()) {
            userEntity.get().setPassword(passwordEncoder.encode(newPassword));
            return userMapper.toDTO(userRepository.saveAndFlush(userEntity.get()));
        } else {
            //throw new Exception()
            return null;
        }
    }

    @Override
    public void logOut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, auth);
        }
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(userMapper::toDTO).orElse(null);
    }

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toDTOList(userRepository.findAll());
    }

    private void sendUserConfirmationMail(String token, UserDTO userDTO) {

        Email from = new Email(userNameFromMail);
        String subject = "Slash Mobility test account registration confirmation";
        Email to = new Email(userDTO.getEmail());
        Content content = new Content("text/plain", "Click the following link in order to complete the registration. " +
                "http://localhost:8080".concat(URLConstants.USER_ROOT).concat(URLConstants.REGISTRATION_CONFIRMED_PATH)
                        .concat("?token=").concat(token));
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sendGrid = new SendGrid(sendGridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sendGrid.api(request);
        } catch(IOException e) {

        }
    }
}
