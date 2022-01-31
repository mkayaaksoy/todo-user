package com.todos.usermanagement.service;

import com.todos.usermanagement.dto.LoginRequestDto;
import com.todos.usermanagement.dto.UserDto;
import com.todos.usermanagement.entity.User;
import com.todos.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

    public boolean login(LoginRequestDto requestDto) {

        var user = userRepository.findByUserName(requestDto.getUsername());
        if(user ==null)
            return false;
        var pass = bCryptPasswordEncoder.encode(requestDto.getPassword());
        if(pass == user.getPassword()){
            return true;
        }
        return false;
    }

    public User register(UserDto userDto) {
        if(userDto.getPassword() == null || userDto.getPassword().equals(""))
            return null;
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        return userRepository.save(userDto.toEntity());
    }

    public UserDto loadUserByUserName(String username) {
            var user = userRepository.findByUserName(username);
        return user.toDto();
    }
}
