package com.betulsahin.schoolmanagementsystemdemov4.utils;

import com.betulsahin.schoolmanagementsystemdemov4.exceptions.StudentAgeNotValidException;

import java.time.LocalDate;

public class StudentValidator {
    private static final int CURRENT_YEAR = 2021;

    public static void validateAge(LocalDate birthdate){
        int age = CURRENT_YEAR - birthdate.getYear();
        if(age < 18 || age > 40){
            throw new StudentAgeNotValidException(
                    String.format(ErrorMessageConstants.NOT_APPROPRIATE_AGE_RANGE, age));
        }
    }
}
