package com.betulsahin.schoolmanagementsystemdemov4.mappers;

import com.betulsahin.schoolmanagementsystemdemov4.dto.CourseRegistrationDto;
import com.betulsahin.schoolmanagementsystemdemov4.entities.CourseRegistration;
import com.betulsahin.schoolmanagementsystemdemov4.services.CourseService;
import com.betulsahin.schoolmanagementsystemdemov4.services.StudentService;
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
