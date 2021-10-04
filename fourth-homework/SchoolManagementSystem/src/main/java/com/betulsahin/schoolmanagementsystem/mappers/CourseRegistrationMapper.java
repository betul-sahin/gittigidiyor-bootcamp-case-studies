package com.betulsahin.schoolmanagementsystem.mappers;

import com.betulsahin.schoolmanagementsystem.dto.CourseRegistrationDto;
import com.betulsahin.schoolmanagementsystem.entities.CourseRegistration;
import com.betulsahin.schoolmanagementsystem.services.CourseService;
import com.betulsahin.schoolmanagementsystem.services.StudentService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CourseRegistrationMapper {

    @Autowired
    protected StudentService studentService;
    @Autowired
    protected CourseService courseService;

    @Mapping(target = "student", expression = "java(studentService.findById(courseRegistrationDtoInput.getStudentId()))")
    @Mapping(target = "course", expression = "java(courseService.findById(courseRegistrationDtoInput.getCourseId()))")
    public abstract CourseRegistration map(CourseRegistrationDto courseRegistrationDtoInput);
}
