package com.todos.usermanagement.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name = "Authorization")
public class TokenTestController {

    @GetMapping("/sayHello")
    public ResponseEntity<String> sayHello(){
        return new ResponseEntity("Hello", HttpStatus.OK);
    }
}
