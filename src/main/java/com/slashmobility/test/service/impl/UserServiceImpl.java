package com.slashmobility.test.service.impl;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.slashmobility.test.entity.UserEntity;
import com.slashmobility.test.mapper.UserMapper;
import com.slashmobility.test.repository.UserRepository;
import com.slashmobility.test.service.UserService;
import com.slashmobility.test.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Value("${spring.mail.username}")
    private String userNameFromMail;

    @Value("${spring.sendgrid.api-key}")
    private String sendGridApiKey;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        /*
        Email from = new Email(userNameFromMail);
        String subject = "Account registration confirmation";
        Email to = new Email(userDTO.getEmail());
        Content content = new Content("text/plain", "Click the following link in order to complete the regsitration." +
                "http://localhost:8080/user/registration?token=testToken348967348953");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sendGrid = new SendGrid(sendGridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
        } catch(IOException e) {

        }*/
        UserEntity userEntity = userMapper.toEntity(userDTO);
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity.setEnabled(Boolean.FALSE);
        userEntity = userRepository.saveAndFlush(userEntity);


        return userMapper.toDTO(userEntity);
    }

    @Override
    public UserDTO enableUser(String validationToken) {
        return null;
    }

    private UserDTO save(UserDTO userDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userDto.setPassword(passwordEncoder.encode((String) authentication.getCredentials()));
        return userMapper.toDTO(userRepository.saveAndFlush(userMapper.toEntity(userDto)));
    }

    @Override
    public UserDTO update(UserDTO userDTO, Long id) {
                /*
        Email from = new Email(userNameFromMail);
        String subject = "Account registration confirmation";
        Email to = new Email(userDTO.getEmail());
        Content content = new Content("text/plain", "Click the following link in order to complete the registration." +
                "http://localhost:8080/user/registration?token=testToken348967348953");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sendGrid = new SendGrid(sendGridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
        } catch(IOException e) {

        }*/
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
}
