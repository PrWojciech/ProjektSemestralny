package com.example.service;


import com.example.model.Course;
import com.example.repo.CourseRepository;
import com.example.repo.UserCourseRepository;
import com.example.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final UserCourseRepository userCourseRepository;
    public CoursesService(CourseRepository courseRepository, UserRepository userRepository, UserCourseRepository userCourseRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.userCourseRepository = userCourseRepository;
    }
    public Course getCourseById(Long id) {

        return courseRepository.getCourseById(id);
    }
    public List<Course> getAllUserCourses(Integer id) {
        return userRepository.getUserCourses(id);
    }
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public boolean userOwnsCourse(Long userId, Long courseId) {
        return userCourseRepository.existsByUser_IdAndCourse_Id(userId, courseId);
    }


}
