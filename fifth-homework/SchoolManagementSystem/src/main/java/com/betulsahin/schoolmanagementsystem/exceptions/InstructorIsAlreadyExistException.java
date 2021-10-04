package com.betulsahin.schoolmanagementsystem.exceptions;

public class InstructorIsAlreadyExistException extends RuntimeException{
    public InstructorIsAlreadyExistException(String message){
        super(message);
    }
}
