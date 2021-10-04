package com.betulsahin.schoolmanagementsystem.repositories;

import com.betulsahin.schoolmanagementsystem.models.abstracts.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Optional<Instructor> findByPhoneNumber(String phoneNumber);
}
