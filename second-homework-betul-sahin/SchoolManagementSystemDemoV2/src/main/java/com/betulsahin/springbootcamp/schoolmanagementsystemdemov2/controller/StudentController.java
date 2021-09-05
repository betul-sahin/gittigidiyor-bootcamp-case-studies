package com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.controller;

import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model.Student;
import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students", headers="Accept=application/json")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(
                studentService.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return new ResponseEntity<>(
                studentService.findById(id),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createStudent(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> editStudent(@RequestBody Student student){
        studentService.update(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}