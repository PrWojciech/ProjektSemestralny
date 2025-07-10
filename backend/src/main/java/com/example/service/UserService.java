package com.example.service;

import com.example.model.UserCredentials;
import com.example.model.Users;

import java.util.Optional;

public interface UserService {
     Users register(Users user);
     String verify(UserCredentials credentials);

     Optional<Users> getUserByUsername(String username);




}
