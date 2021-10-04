package com.betulsahin.schoolmanagementsystem.mappers;

import com.betulsahin.schoolmanagementsystem.dtos.CourseDto;
import com.betulsahin.schoolmanagementsystem.models.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course map(CourseDto courseDto);
    CourseDto mapToDto(Course course);
}
