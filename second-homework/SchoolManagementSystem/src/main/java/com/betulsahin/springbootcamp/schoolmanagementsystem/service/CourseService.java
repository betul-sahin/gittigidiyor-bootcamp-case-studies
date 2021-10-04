package com.betulsahin.springbootcamp.schoolmanagementsystem.service;

import com.betulsahin.springbootcamp.schoolmanagementsystem.model.Course;
import com.betulsahin.springbootcamp.schoolmanagementsystem.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseService implements BaseService<Course>{
    private CrudRepository courseDaoJpa;

    public CourseService(@Qualifier("courseDaoJpaImpl") CrudRepository courseDaoJpa) {
        this.courseDaoJpa = courseDaoJpa;
    }

    @Override
    public List<Course> findAll() {
        return courseDaoJpa.findAll();
    }

    @Override
    public Course findById(Long id) {
        return (Course) courseDaoJpa.findById(id);
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return (Course) courseDaoJpa.save(course);
    }

    @Override
    @Transactional
    public Course update(Course course) {
        return (Course) courseDaoJpa.update(course);
    }

    @Override
    public void deleteById(Long id) {
        courseDaoJpa.deleteById(id);
    }
}
