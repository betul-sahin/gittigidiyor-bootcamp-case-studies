package com.betulsahin.schoolmanagementsystem.controllers;

import com.betulsahin.schoolmanagementsystem.dto.InstructorDto;
import com.betulsahin.schoolmanagementsystem.entities.Instructor;
import com.betulsahin.schoolmanagementsystem.services.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @PostMapping
    public ResponseEntity<Instructor> create(@RequestBody InstructorDto request){
        Optional<Instructor> instructorOptional = instructorService.create(request);

        if(instructorOptional.isPresent()){
            return new ResponseEntity<>(instructorOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<InstructorDto>> getAll(){
        final List<InstructorDto> instructors = instructorService.findAll();

        return new ResponseEntity<List<InstructorDto>>(
                instructors,
                HttpStatus.OK
        );
    }
}
