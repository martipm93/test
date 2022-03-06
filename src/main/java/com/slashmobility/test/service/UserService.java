package com.slashmobility.test.service;

import com.slashmobility.test.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface UserService {

    UserDTO newUser(UserDTO userDTO);

    UserDTO save(UserDTO userDto);

    UserDTO resetPassword(UserDTO userDto);

    void logOut(HttpServletRequest httpServletRequest);

    Optional<UserDTO> findById(Long id);

    List<UserDTO> findAll();

}
