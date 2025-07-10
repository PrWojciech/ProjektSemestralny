package com.example.repo;

import com.example.model.Course;
import com.example.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

     Optional<Users> findByUsername(String username);
     @Query("""
    SELECT uc.course
    FROM UserCourse uc
    WHERE uc.user.id = :userId
""")
     List<Course> getUserCourses(@Param("userId") Integer userId);




}

