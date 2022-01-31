package com.todos.usermanagement.service;

import com.todos.usermanagement.dto.UserDto;
import com.todos.usermanagement.entity.User;
import com.todos.usermanagement.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private UserService userService;
    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @BeforeEach
    void init() {
        userRepository = Mockito.mock(UserRepository.class);
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userService = new UserService(userRepository, bCryptPasswordEncoder);
    }

    @Test
    void register(){
        when(userRepository.save(any(User.class))).thenReturn(new User(1l, "fn", "ln", "un", "mail", "pass"));
        var user = userService.register(new UserDto());
    }


}
