package com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.service;

import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model.Course;
import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model.CourseRegistration;
import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model.Student;
import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
