package com.slashmobility.test.service;

import com.slashmobility.test.web.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO enableUser(String validationToken);

    UserDTO update(UserDTO userDTO, Long id);

    UserDTO resetPassword(String newPassword);

    void logOut(HttpServletRequest httpServletRequest);

    UserDTO findById(Long id);

    List<UserDTO> findAll();

}
