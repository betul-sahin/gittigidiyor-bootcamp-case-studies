package com.betulsahin.schoolmanagementsystemdemov4.dto;

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
