package com.todos.usermanagement.controller;

import com.todos.usermanagement.dto.LoginRequestDto;
import com.todos.usermanagement.dto.UserDto;
import com.todos.usermanagement.entity.User;
import com.todos.usermanagement.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "UserApi")
public class UserController {

    @Qualifier("userServiceImpl")
    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    @Operation(summary  = "Login method", description = "bar")
    boolean login(@RequestBody LoginRequestDto requestDto){
        return userService.login(requestDto);
    }

    @PostMapping("/register")
    @Operation(summary  = "Register Method", description = "bar")
    ResponseEntity<UserDto> register(@RequestBody UserDto userDto){
        var user = userService.register(userDto);
        if(user != null){
            return new ResponseEntity(user, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
