package com.betulsahin.schoolmanagementsystemdemov4.services;

import com.betulsahin.schoolmanagementsystemdemov4.dto.LogDto;
import com.betulsahin.schoolmanagementsystemdemov4.entities.Log;
import com.betulsahin.schoolmanagementsystemdemov4.mappers.LogMapper;
import com.betulsahin.schoolmanagementsystemdemov4.repositories.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;
    private final LogMapper logMapper;

    /**
     * logs exception detail to database.
     *
     * @param exceptionType the type of thrown exception
     * @param exceptionMessage the message of thrown exception
     * @param throwedDate the date of thrown exception
     */
    public void log(String exceptionType, String exceptionMessage, Instant throwedDate) {
        logRepository.save(new Log(0L, exceptionType, exceptionMessage, throwedDate));
    }

    /**
     * gets all exceptions by filters
     *
     * @param exceptionType the type of thrown exception
     * @param throwedDate the date of thrown exception
     * @return list of LogDto object
     */
    @Transactional(readOnly = true)
    public List<LogDto> findAllByExceptionTypeOrThrowedDate(String exceptionType, Instant throwedDate) {
        Optional<List<Log>> optionalLogs = logRepository.findAllByExceptionTypeOrThrowedDateOrderByThrowedDate(exceptionType, throwedDate);

        if(optionalLogs.isPresent()){
            return optionalLogs.get()
                    .stream()
                    .map(logMapper::mapToDto)
                    .collect(Collectors.toList());
        }

        return logRepository.findAll()
                .stream()
                .map(logMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
