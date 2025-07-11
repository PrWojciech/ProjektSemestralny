package com.example.service;

import com.example.model.Course;
import com.example.repo.CourseRepository;
import com.example.repo.UserCourseRepository;
import com.example.repo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CoursesServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserCourseRepository userCourseRepository;

    @InjectMocks
    private CoursesService coursesService;

    private Course c1, c2;

    @BeforeEach
    void setUp() {
        c1 = new Course();
        c1.setId(1);
        c1.setTitle("A");

        c2 = new Course();
        c2.setId(2);
        c2.setTitle("B");
    }

    @Test
    void getCourseById_whenValidId_thenReturnCourse() {

        when(courseRepository.getCourseById(1L)).thenReturn(c1);

        Course result = coursesService.getCourseById(1L);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getTitle()).isEqualTo("A");

        verify(courseRepository, times(1)).getCourseById(1L);
    }

    @Test
    void getCourseById_whenUnknownId_thenReturnNull() {

        when(courseRepository.getCourseById(99L)).thenReturn(null);

        Course result = coursesService.getCourseById(99L);

        assertThat(result).isNull();

        verify(courseRepository, times(1)).getCourseById(99L);
    }

    @Test
    void getAllCourses_shouldReturnAll() {
        when(courseRepository.findAll()).thenReturn(Arrays.asList(c1, c2));

        List<Course> all = coursesService.getAllCourses();

        assertThat(all).hasSize(2)
                .extracting("id")
                .containsExactlyInAnyOrder(1, 2);

        verify(courseRepository, times(1)).findAll();
    }

    @Test
    void getAllUserCourses_whenUserHasCourses() {
        when(userRepository.getUserCourses(10)).thenReturn(Arrays.asList(c1, c2));

        List<Course> userCourses = coursesService.getAllUserCourses(10);

        assertThat(userCourses).hasSize(2)
                .extracting(Course::getTitle)
                .containsExactly("A","B");

        verify(userRepository, times(1)).getUserCourses(10);
    }

    @Test
    void getAllUserCourses_whenUserHasNoCourses() {
        when(userRepository.getUserCourses(99)).thenReturn(Collections.emptyList());

        List<Course> userCourses = coursesService.getAllUserCourses(99);

        assertThat(userCourses).isEmpty();
        verify(userRepository, times(1)).getUserCourses(99);
    }

    @Test
    void userOwnsCourse_whenExists_returnTrue() {
        when(userCourseRepository.existsByUser_IdAndCourse_Id(5L, 7L)).thenReturn(true);

        boolean owns = coursesService.userOwnsCourse(5L, 7L);

        assertThat(owns).isTrue();
        verify(userCourseRepository, times(1))
                .existsByUser_IdAndCourse_Id(5L, 7L);
    }

    @Test
    void userOwnsCourse_whenNotExists_returnFalse() {
        when(userCourseRepository.existsByUser_IdAndCourse_Id(5L, 8L)).thenReturn(false);

        boolean owns = coursesService.userOwnsCourse(5L, 8L);

        assertThat(owns).isFalse();
        verify(userCourseRepository, times(1))
                .existsByUser_IdAndCourse_Id(5L, 8L);
    }
}
