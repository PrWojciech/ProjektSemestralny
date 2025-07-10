package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lesson_index")
    private float lessonIndex;

    @ManyToOne
    @JoinColumn(name = "section_id")
    @JsonBackReference
    private Section section;

    @Column(name = "lesson_title")
    private String lessonTitle;

    @Column(name = "movie_title")
    private String movieTitle;

    @Column(name = "movie_length")
    private Timestamp movieLength;

    @Column(name = "movie_localization")
    private String movieLocation;

    @Column(name = "description")
    private String description;


}
