package com.betulsahin.schoolmanagementsystem.service;

import com.betulsahin.schoolmanagementsystem.entity.Course;
import com.betulsahin.schoolmanagementsystem.entity.CourseRegistration;
import com.betulsahin.schoolmanagementsystem.entity.Student;
import com.betulsahin.schoolmanagementsystem.exception.CourseNotFoundException;
import com.betulsahin.schoolmanagementsystem.exception.StudentNotFoundException;
import com.betulsahin.schoolmanagementsystem.repository.CourseRegistrationRepository;
import com.betulsahin.schoolmanagementsystem.repository.CourseRepository;
import com.betulsahin.schoolmanagementsystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class CourseRegistrationService {
    private static final String COURSE_NOT_FOUND = "Course not found with this id : ";
    private static final String STUDENT_NOT_FOUND = "Student not found with this id : " ;

    private final CourseRegistrationRepository courseRegistrationRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public void register(Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(
                        String.format(COURSE_NOT_FOUND, courseId)));

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(
                        String.format(STUDENT_NOT_FOUND, studentId)));

        CourseRegistration registration = new CourseRegistration(LocalDate.now());
        registration.setCourse(course);
        registration.setStudent(student);

        courseRegistrationRepository.save(registration);
    }
}
