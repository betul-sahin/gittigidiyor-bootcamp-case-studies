package com.betulsahin.schoolmanagementsystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRegistrationDto {
    private long id;
    private long studentId;
    private long courseId;
}
