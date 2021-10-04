package com.betulsahin.schoolmanagementsystem.utils;

import com.betulsahin.schoolmanagementsystem.exceptions.RequestDateTimeParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InstructorValidator {
    public static void validateRequestDate(String requestDate, DateTimeFormatter formatter){
        try{
            LocalDate.parse(requestDate, formatter);
        }
        catch (DateTimeParseException e){
            throw new RequestDateTimeParseException(ErrorMessageConstants.DATE_FORMAT_WRONG + requestDate);
        }
    }
}
