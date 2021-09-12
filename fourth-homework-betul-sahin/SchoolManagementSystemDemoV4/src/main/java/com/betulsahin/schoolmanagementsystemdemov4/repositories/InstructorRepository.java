package com.betulsahin.schoolmanagementsystemdemov4.repositories;

import com.betulsahin.schoolmanagementsystemdemov4.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Optional<Instructor> findByPhoneNumber(String phoneNumber);
}
