package com.betulsahin.schoolmanagementsystemdemov4.mappers;

import com.betulsahin.schoolmanagementsystemdemov4.dto.CourseDto;
import com.betulsahin.schoolmanagementsystemdemov4.entities.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course map(CourseDto courseDtoInput);
}
