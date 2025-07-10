package com.example.repo;

import com.example.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Lessonrepository extends JpaRepository<Lesson, Integer> {
    public Lesson getLessonById(Integer id);
}
