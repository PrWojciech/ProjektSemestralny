package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_courses")
public class UserCourse {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "user_id", nullable = false)
        private Users user;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "course_id", nullable = false)
        private Course course;

}
