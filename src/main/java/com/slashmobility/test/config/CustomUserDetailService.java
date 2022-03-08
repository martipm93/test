package com.slashmobility.test.config;

import com.slashmobility.test.entity.UserEntity;
import com.slashmobility.test.mapper.UserMapper;
import com.slashmobility.test.repository.UserRepository;
import com.slashmobility.test.web.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public CustomUserDetailService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional <UserEntity> userEntity = userRepository.findByUsernameEquals(username);
        return userEntity.map(u -> userMapper.toDTO(u)).orElse(null);
    }
}
