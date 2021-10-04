package com.betulsahin.schoolmanagementsystem.repositories;

import com.betulsahin.schoolmanagementsystem.models.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Long> {
    @Query("SELECT COUNT(cr) FROM CourseRegistration cr WHERE cr.course.id = ?1")
    int findStudentCountByCourse(long courseId);

    Optional<CourseRegistration> findByStudentIdAndCourseId(long studentId, long courseId);
}
