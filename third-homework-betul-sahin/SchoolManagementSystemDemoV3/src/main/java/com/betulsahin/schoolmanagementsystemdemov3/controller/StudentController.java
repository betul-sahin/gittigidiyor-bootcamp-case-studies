package com.betulsahin.schoolmanagementsystemdemov3.controller;

import com.betulsahin.schoolmanagementsystemdemov3.entity.Student;
import com.betulsahin.schoolmanagementsystemdemov3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students", headers = "Accept=application/json")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(
                studentService.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("/byNameContaining/{searchWord}")
    public ResponseEntity<List<Student>> getAllStudentsWithNameContaining(@PathVariable String searchWord) {
        return new ResponseEntity<>(
                studentService.findAllByNameContaining(searchWord),
                HttpStatus.OK);
    }

    @GetMapping("/byGenderWithGrouping")
    public ResponseEntity<List<?>> getAllStudentsWithGenderGrouping() {
        return new ResponseEntity<>(
                studentService.findAllByGendersWithGrouping(),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return new ResponseEntity<>(
                studentService.findById(id),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createStudent(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> editStudent(@RequestBody Student student) {
        studentService.update(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/byName/{name}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String name) {
        studentService.deleteByName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}