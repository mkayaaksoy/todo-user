package com.todos.usermanagement.service;

import com.todos.usermanagement.dto.LoginRequestDto;
import com.todos.usermanagement.dto.UserDto;
import com.todos.usermanagement.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    boolean login(LoginRequestDto requestDto);
    User register(UserDto userDto);
    UserDto loadUserByUserName(String email);

}
