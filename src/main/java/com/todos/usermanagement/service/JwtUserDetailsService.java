package com.todos.usermanagement.service;

import com.todos.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public JwtUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var userRes = userRepository.findByUserName(username);
        if ( userRes == null){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(userRes.getUserName(), userRes.getPassword(), new ArrayList<>());
    }
}
