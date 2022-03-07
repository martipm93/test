package com.slashmobility.test.service.impl;

import com.slashmobility.test.mapper.UserMapper;
import com.slashmobility.test.repository.UserRepository;
import com.slashmobility.test.service.UserService;
import com.slashmobility.test.web.dto.UserDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO newUser(UserDTO userDTO) {
        return null;
    }

    private UserDTO save(UserDTO userDto) {
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
    public UserDTO resetPassword(UserDTO userDto) {
        return null;
    }

    @Override
    public void logOut(HttpServletRequest httpServletRequest) {

    }

    @Override
    public UserDTO findById(Long id) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }
}
