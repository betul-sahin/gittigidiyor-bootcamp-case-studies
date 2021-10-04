package com.betulsahin.schoolmanagementsystem.mappers;

import com.betulsahin.schoolmanagementsystem.dtos.StudentDto;
import com.betulsahin.schoolmanagementsystem.models.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student map(StudentDto studentDto);
    StudentDto mapToDto(Student student);
}
