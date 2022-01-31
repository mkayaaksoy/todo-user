package com.todos.usermanagement.controller;

import com.todos.usermanagement.configuration.security.JwtTokenUtil;
import com.todos.usermanagement.dto.LoginRequestDto;
import com.todos.usermanagement.dto.LoginResponseDto;
import com.todos.usermanagement.dto.UserDto;
import com.todos.usermanagement.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@Tag(name = "UserApi")
public class UserController {

    // TODO: 1/27/2022 we can generate ErrorCodes CustomErrorObject and ExceptiponHandler

    private UserService userService;
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public UserController(UserService userService,
                          AuthenticationManager authenticationManager,
                          JwtTokenUtil jwtTokenUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    @Operation(summary  = "Login method", description = "bar")
    ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto requestDto){
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            requestDto.getUsername(),
                            requestDto.getPassword()));
            User user = (User) auth.getPrincipal();
            var loginResponse = new LoginResponseDto(jwtTokenUtil.generateToken(user));
            return new ResponseEntity(loginResponse, HttpStatus.OK);
        }catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
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
