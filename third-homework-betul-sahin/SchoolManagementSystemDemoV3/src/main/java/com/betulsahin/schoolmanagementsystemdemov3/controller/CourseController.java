package com.betulsahin.schoolmanagementsystemdemov3.controller;

import com.betulsahin.schoolmanagementsystemdemov3.entity.Course;
import com.betulsahin.schoolmanagementsystemdemov3.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(
                courseService.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("/byNameContaining/{searchWord}")
    public ResponseEntity<List<Course>> getAllCoursesbyNameContaining(String searchWord) {
        return new ResponseEntity<>(
                courseService.findAllByNameContaining(searchWord),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        return new ResponseEntity<>(
                courseService.findById(id),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createCourse(@RequestBody Course course) {
        courseService.save(course);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> editCourse(@RequestBody Course course) {
        courseService.update(course);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/byName/{name}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String name) {
        courseService.deleteByName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
