package com.betulsahin.springbootcamp.schoolmanagementsystem.service;

import com.betulsahin.springbootcamp.schoolmanagementsystem.model.Course;
import com.betulsahin.springbootcamp.schoolmanagementsystem.model.CourseRegistration;
import com.betulsahin.springbootcamp.schoolmanagementsystem.model.Student;
import com.betulsahin.springbootcamp.schoolmanagementsystem.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CourseRegistrationService {
    private CrudRepository courseRegistrationDaoJpa;
    private CourseService courseService;
    private StudentService studentService;

    public CourseRegistrationService(@Qualifier("courseRegistrationDaoJpaImpl") CrudRepository courseRegistrationDaoJpa,
                                     CourseService courseService,
                                     StudentService studentService) {
        this.courseRegistrationDaoJpa = courseRegistrationDaoJpa;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    public void register(Long courseId, Long studentId) {
        Course course = courseService.findById(courseId);
        Student student = studentService.findById(studentId);

        CourseRegistration registration = new CourseRegistration(LocalDate.now());
        registration.setCourse(course);
        registration.setStudent(student);

        courseRegistrationDaoJpa.save(registration);
    }
}
