package com.slashmobility.test.service;

import com.slashmobility.test.web.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    UserDTO newUser(UserDTO userDTO);

    UserDTO update(UserDTO userDTO, Long id);

    UserDTO resetPassword(UserDTO userDto);

    void logOut(HttpServletRequest httpServletRequest);

    UserDTO findById(Long id);

    List<UserDTO> findAll();

}
