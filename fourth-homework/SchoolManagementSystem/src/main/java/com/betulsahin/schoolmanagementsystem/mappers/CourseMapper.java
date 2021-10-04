package com.betulsahin.schoolmanagementsystem.mappers;

import com.betulsahin.schoolmanagementsystem.dto.CourseDto;
import com.betulsahin.schoolmanagementsystem.entities.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course map(CourseDto courseDtoInput);
}
