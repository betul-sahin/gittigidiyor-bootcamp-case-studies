package com.betulsahin.schoolmanagementsystemdemov4.controllers;

import com.betulsahin.schoolmanagementsystemdemov4.dto.LogDto;
import com.betulsahin.schoolmanagementsystemdemov4.services.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/logs")
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;

    @GetMapping("/{exceptionType}/{throwedDate}")
    public ResponseEntity<List<LogDto>> getLogDetails(@PathVariable String exceptionType,
                                                      @PathVariable Instant throwedDate){
        return new ResponseEntity<List<LogDto>>(
                logService.findAllByExceptionTypeOrThrowedDate(exceptionType, throwedDate),
                HttpStatus.OK);
    }
}
