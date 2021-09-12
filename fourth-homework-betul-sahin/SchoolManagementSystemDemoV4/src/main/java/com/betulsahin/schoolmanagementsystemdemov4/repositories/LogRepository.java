package com.betulsahin.schoolmanagementsystemdemov4.repositories;

import com.betulsahin.schoolmanagementsystemdemov4.entities.Log;
import com.sun.istack.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    Optional<List<Log>> findAllByExceptionTypeOrThrowedDateOrderByThrowedDate( String exceptionType,  Instant throwedDate);
}
