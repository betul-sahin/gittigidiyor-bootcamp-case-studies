package com.betulsahin.schoolmanagementsystemdemov4.controllers;

import com.betulsahin.schoolmanagementsystemdemov4.dto.CourseDto;
import com.betulsahin.schoolmanagementsystemdemov4.entities.Course;
import com.betulsahin.schoolmanagementsystemdemov4.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody CourseDto request){
        Optional<Course> courseOptional = courseService.create(request);

        if(courseOptional.isPresent()){
            return new ResponseEntity<>(courseOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
