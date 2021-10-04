package com.betulsahin.springbootcamp.schoolmanagementsystem.model;

public enum GenderType {
    FEMALE("Female"),
    MALE("Male");

    private String genderName;

    GenderType(String genderName){
        this.genderName = genderName;
    }

    public String getGenderName(){
        return genderName;
    }
}
