package com.betulsahin.schoolmanagementsystemdemov3.service;

import com.betulsahin.schoolmanagementsystemdemov3.entity.Course;
import com.betulsahin.schoolmanagementsystemdemov3.exception.CourseNotFoundException;
import com.betulsahin.schoolmanagementsystemdemov3.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService implements BaseService<Course>{
    private static final String COURSE_NOT_FOUND = "Course not found with this id : ";

    private final CourseRepository courseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll()
                .iterator()
                .forEachRemaining(courses::add);

        return courses;
    }

    @Transactional(readOnly = true)
    public List<Course> findAllByNameContaining(String searchWord) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAllByNameContainingIgnoreCase(searchWord)
                .iterator()
                .forEachRemaining(courses::add);

        return courses;
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(
                        String.format(COURSE_NOT_FOUND, id)));
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public Course update(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Transactional
    public void deleteByName(String name) {
        courseRepository.deleteByName(name);
    }
}
