package com.betulsahin.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogDto {
    private String exceptionType;
    private String exceptionMessage;
    private Instant throwedDate;
}
