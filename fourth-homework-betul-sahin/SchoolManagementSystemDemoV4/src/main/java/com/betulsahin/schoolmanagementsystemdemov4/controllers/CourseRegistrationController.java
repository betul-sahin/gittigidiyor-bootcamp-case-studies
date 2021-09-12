package com.betulsahin.schoolmanagementsystemdemov4.controllers;

import com.betulsahin.schoolmanagementsystemdemov4.dto.CourseRegistrationDto;
import com.betulsahin.schoolmanagementsystemdemov4.entities.CourseRegistration;
import com.betulsahin.schoolmanagementsystemdemov4.services.CourseRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/course-registration")
@RequiredArgsConstructor
public class CourseRegistrationController {

    private final CourseRegistrationService courseRegistrationService;

    @PostMapping
    public ResponseEntity<CourseRegistration> create(@RequestBody CourseRegistrationDto request) {
        Optional<CourseRegistration> courseRegistrationOptional = courseRegistrationService.create(request);

        if (courseRegistrationOptional.isPresent()) {
            return new ResponseEntity<>(courseRegistrationOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
