package com.betulsahin.schoolmanagementsystem.repository;

import com.betulsahin.schoolmanagementsystem.entity.CourseRegistration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegistrationRepository extends CrudRepository<CourseRegistration, Long> {
}
