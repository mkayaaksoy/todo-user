package com.todos.usermanagement.service.Impl;

import com.todos.usermanagement.dto.LoginRequestDto;
import com.todos.usermanagement.dto.UserDto;
import com.todos.usermanagement.entity.User;
import com.todos.usermanagement.repository.UserRepository;
import com.todos.usermanagement.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean login(LoginRequestDto requestDto) {
        return false;
    }

    @Override
    public User register(UserDto userDto) {
        return userRepository.save(userDto.toEntity());
    }

    @Override
    public UserDto loadUserByUserName(String username) {
        var user = userRepository.findByUserName(username);
        return user.toDto();
    }
}
