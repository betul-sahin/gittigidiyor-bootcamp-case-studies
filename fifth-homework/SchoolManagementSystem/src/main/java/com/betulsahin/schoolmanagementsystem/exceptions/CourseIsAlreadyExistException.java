package com.betulsahin.schoolmanagementsystem.exceptions;

public class CourseIsAlreadyExistException extends RuntimeException{
    public CourseIsAlreadyExistException(String message){
        super(message);
    }
}
