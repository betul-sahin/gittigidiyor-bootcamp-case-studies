package com.betulsahin.schoolmanagementsystemdemov3.controller;

import com.betulsahin.schoolmanagementsystemdemov3.entity.Instructor;
import com.betulsahin.schoolmanagementsystemdemov3.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        return new ResponseEntity<>(
                instructorService.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("/byNameContaining/{searchWord")
    public ResponseEntity<List<Instructor>> getAllInstructors(String searchWord) {
        return new ResponseEntity<>(
                instructorService.findAllByNameContaining(searchWord),
                HttpStatus.OK);
    }

    @GetMapping("/top3BySalaryGreaterThan")
    public ResponseEntity<List<?>> getAllTop3BySalaryGreaterThan(){
        return new ResponseEntity<>(
                instructorService.findAllTop3BySalaryGreaterThan(),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Instructor> getInstructor(@PathVariable Long id) {
        return new ResponseEntity<>(
                instructorService.findById(id),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createInstructor(@RequestBody Instructor instructor) {
        instructorService.save(instructor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> editInstructor(@RequestBody Instructor instructor) {
        instructorService.update(instructor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        instructorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/byName/{name}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable String name) {
        instructorService.deleteByName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
