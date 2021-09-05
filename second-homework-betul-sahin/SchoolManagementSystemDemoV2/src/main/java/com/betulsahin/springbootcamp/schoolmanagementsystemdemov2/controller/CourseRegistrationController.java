package com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.controller;

import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/courseregistration")
public class CourseRegistrationController {
    private CourseRegistrationService courseRegistrationService;

    @Autowired
    public CourseRegistrationController(CourseRegistrationService courseRegistrationService) {
        this.courseRegistrationService = courseRegistrationService;
    }

    @PostMapping("/{courseId}/{studentId}")
    public ResponseEntity<Void> register(@PathVariable Long courseId, @PathVariable Long studentId){
        courseRegistrationService.register(courseId, studentId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
