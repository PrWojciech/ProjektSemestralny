package com.example.controller;

import com.example.model.Course;
import com.example.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/courses")
public class CoursesController  {


    private final CoursesService coursesService;


    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @GetMapping("/auth/my-courses")
    public List<Course> getMyCourses() {

        int i =1;

        return coursesService.getAllUserCourses(1);
    }

    @GetMapping("/auth/{id}")
    public ResponseEntity<Course> GetCourseByID(@PathVariable Long id,@AuthenticationPrincipal Jwt jwt) {
        Long userId = jwt.getClaim("userId");

        if (!coursesService.userOwnsCourse(userId, id)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build(); // lub throw exception
        }

        Course course = coursesService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/allCourses")
    public List<Course> getAllCourses(){
        return coursesService.getAllCourses();
    }


}