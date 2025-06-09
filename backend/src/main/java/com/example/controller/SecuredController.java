package com.example.controller;

import com.example.model.Users;
import java.util.List;

import com.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredController {
    @Autowired
    UserRepository repo;
    @GetMapping("/getUsers")
    public List<Users> getUsers(){
        return repo.findAll();
    }
}
