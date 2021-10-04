package com.betulsahin.schoolmanagementsystem.exceptions;

public class StudentIsAlreadyRegisteredCourseException extends RuntimeException{
    public StudentIsAlreadyRegisteredCourseException(String message){
        super(message);
    }
}
