package com.betulsahin.schoolmanagementsystemdemov3.repository;

import com.betulsahin.schoolmanagementsystemdemov3.entity.CourseRegistration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegistrationRepository extends CrudRepository<CourseRegistration, Long> {
}
