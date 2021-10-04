package com.betulsahin.schoolmanagementsystem.controllers;

import com.betulsahin.schoolmanagementsystem.dto.StudentDto;
import com.betulsahin.schoolmanagementsystem.entities.Student;
import com.betulsahin.schoolmanagementsystem.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentDto studentDto) {
        Optional<Student> studentOptional = studentService.create(studentDto);

        if(studentOptional.isPresent()){
            return new ResponseEntity<>(studentOptional.get(), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
