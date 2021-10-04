package com.betulsahin.schoolmanagementsystem.exceptions;

public class StudentIsAlreadyRegisteredThisCourseExistException extends RuntimeException{
    public StudentIsAlreadyRegisteredThisCourseExistException(String message){
        super(message);
    }
}
