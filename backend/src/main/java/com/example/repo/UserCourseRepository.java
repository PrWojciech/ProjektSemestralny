package com.example.repo;

import com.example.model.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {
    boolean existsByUser_IdAndCourse_Id(Long userId, Long courseId);

}