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
import com.slashmobility.test.web.endpoint.constants.URLConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userDto.setPassword(passwordEncoder.encode((String) authentication.getCredentials()));
        return userMapper.toDTO(userRepository.saveAndFlush(userMapper.toEntity(userDto)));
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
        return null;
    }

    @Override
    public void logOut(HttpServletRequest httpServletRequest) {

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
