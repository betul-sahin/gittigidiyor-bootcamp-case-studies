package com.betulsahin.schoolmanagementsystem.repository;

import com.betulsahin.schoolmanagementsystem.model.Course;
import com.betulsahin.schoolmanagementsystem.model.Student;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student> {
    List<Course> findCoursesOfStudent(Long studentId);
}
