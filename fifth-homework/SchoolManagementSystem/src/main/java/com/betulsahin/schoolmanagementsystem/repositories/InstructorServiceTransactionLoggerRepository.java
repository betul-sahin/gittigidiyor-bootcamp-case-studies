package com.betulsahin.schoolmanagementsystem.repositories;

import com.betulsahin.schoolmanagementsystem.models.InstructorServiceTransactionLogger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InstructorServiceTransactionLoggerRepository extends PagingAndSortingRepository<InstructorServiceTransactionLogger, Long> {
    @Query("SELECT ins FROM InstructorServiceTransactionLogger ins WHERE ins.requestDateTime = ?1")
    Page<List<InstructorServiceTransactionLogger>> findAllTransactionByRequestDate(LocalDate requestDate, Pageable pageable);

    @Query("SELECT ins FROM InstructorServiceTransactionLogger ins WHERE ins.instructorId = ?1")
    Page<List<InstructorServiceTransactionLogger>> findAllTransactionByInstructorId(long instructorId, Pageable pageable);
}