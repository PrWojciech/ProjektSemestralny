package com.example.controller;

import com.example.model.Course;
import com.example.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/courses")
public class CoursesController  {
    private final MyUserService myUserService;

    @Autowired
    public CoursesController(MyUserService myUserService){
        this.myUserService = myUserService;
    }

    @GetMapping("/my-courses")
    public List<Course> getMyCourses() {
        String loggedInUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        return myUserService.getUsersCourses(loggedInUsername);
    }


}