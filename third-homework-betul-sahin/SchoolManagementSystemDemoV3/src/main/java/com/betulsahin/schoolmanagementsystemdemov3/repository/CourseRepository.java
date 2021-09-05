package com.betulsahin.schoolmanagementsystemdemov3.repository;

import com.betulsahin.schoolmanagementsystemdemov3.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAllByNameContainingIgnoreCase(String searchWord);

    void deleteByName(String name);
}
