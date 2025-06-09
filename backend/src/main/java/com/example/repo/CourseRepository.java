package com.example.repo;

import com.example.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

   @Query(value = "SELECT c.id, c.title, c.description FROM courses c " +
           "JOIN user_courses uc ON c.id = uc.course_id " +
           "WHERE uc.user_id = :userId", nativeQuery = true)
   List<Course> findCoursesByUserId(@Param("userId") Long userId);
}
