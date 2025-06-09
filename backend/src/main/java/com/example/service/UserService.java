package com.example.service;

import com.example.model.Course;
import com.example.model.Users;

import java.util.List;

public interface UserService {
     Users register(Users user);
     String verify(String username, String password);

     Users getUserByUsername(String username);

     List<Course> getUsersCourses(String username);
}
