package com.betulsahin.schoolmanagementsystem.mappers;

import com.betulsahin.schoolmanagementsystem.dto.StudentDto;
import com.betulsahin.schoolmanagementsystem.entities.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

        Student map(StudentDto studentDtoInput);

    // public StudentDtoOutput mapToDto(Student student);
}
