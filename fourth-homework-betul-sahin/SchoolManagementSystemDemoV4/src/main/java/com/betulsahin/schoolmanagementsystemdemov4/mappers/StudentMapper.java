package com.betulsahin.schoolmanagementsystemdemov4.mappers;

import com.betulsahin.schoolmanagementsystemdemov4.dto.StudentDto;
import com.betulsahin.schoolmanagementsystemdemov4.entities.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

        Student map(StudentDto studentDtoInput);

    // public StudentDtoOutput mapToDto(Student student);
}
