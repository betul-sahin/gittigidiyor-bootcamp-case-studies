package com.betulsahin.schoolmanagementsystemdemov4.exceptions;

public class CourseIsAlreadyExistException extends RuntimeException{
    public CourseIsAlreadyExistException(String message){
        super(message);
    }
}
