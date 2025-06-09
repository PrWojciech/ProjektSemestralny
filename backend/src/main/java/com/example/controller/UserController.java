package com.example.controller;

import com.example.model.Users;
import com.example.service.MyUserService;
import com.example.model.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private MyUserService myUserService;

    // Register new user
    @PostMapping("/register")
    public Users register(@RequestBody Users user) {

        return myUserService.register(user);
    }

    // Login existing user
    @PostMapping("/login")
    public String login(@RequestBody UserCredentials credentials) {
        return myUserService.verify(credentials.getUsername(), credentials.getPassword());
    }
}
