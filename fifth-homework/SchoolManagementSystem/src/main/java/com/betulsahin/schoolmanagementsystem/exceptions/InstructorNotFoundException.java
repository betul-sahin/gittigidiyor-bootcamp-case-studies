package com.betulsahin.schoolmanagementsystem.exceptions;

public class InstructorNotFoundException extends RuntimeException{
    public InstructorNotFoundException(String message){
        super(message);
    }
}
