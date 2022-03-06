package com.slashmobility.test.service.impl;

import com.slashmobility.test.service.UserService;
import com.slashmobility.test.web.dto.UserDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO newUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO save(UserDTO userDto) {
        return null;
    }

    @Override
    public UserDTO resetPassword(UserDTO userDto) {
        return null;
    }

    @Override
    public void logOut(HttpServletRequest httpServletRequest) {

    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }
}
