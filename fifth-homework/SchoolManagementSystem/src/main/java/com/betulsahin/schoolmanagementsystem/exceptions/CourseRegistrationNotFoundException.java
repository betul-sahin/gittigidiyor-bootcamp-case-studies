package com.betulsahin.schoolmanagementsystem.exceptions;

public class CourseRegistrationNotFoundException extends RuntimeException{
    public CourseRegistrationNotFoundException(String message){
        super(message);
    }
}
