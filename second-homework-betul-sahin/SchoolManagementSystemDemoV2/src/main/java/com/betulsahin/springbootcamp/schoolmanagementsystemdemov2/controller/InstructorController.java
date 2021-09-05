package com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.controller;

import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model.Instructor;
import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model.PermanentInstructor;
import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model.VisitingResearcher;
import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.service.InstructorService;
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
    public ResponseEntity<List<Instructor>> getAllInstructors(){
        return new ResponseEntity<>(
                instructorService.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Instructor> getInstructor(@PathVariable Long id){
        return new ResponseEntity<>(
                instructorService.findById(id),
                HttpStatus.OK);
    }

    /*@PostMapping("/permanent")
    public ResponseEntity<Void> createPermanentInstructor(@RequestBody PermanentInstructor permanentInstructor){
        instructorService.save(permanentInstructor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/visitingresearcher")
    public ResponseEntity<Void> createVisitingResearcher(@RequestBody VisitingResearcher visitingResearcher){
        instructorService.save(visitingResearcher);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }*/

    @PostMapping
    public ResponseEntity<Void> createInstructor(@RequestBody Instructor instructor){
        instructorService.save(instructor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> editInstructor(@RequestBody Instructor instructor){
        instructorService.update(instructor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*@PutMapping("/permanent")
    public ResponseEntity<Void> editPermanentInstructor(@RequestBody PermanentInstructor permanentInstructor){
        instructorService.update(permanentInstructor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/visitingresearcher")
    public ResponseEntity<Void> editVisitingResearcher(@RequestBody VisitingResearcher visitingResearcher){
        instructorService.update(visitingResearcher);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id){
        instructorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
