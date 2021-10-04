package com.betulsahin.schoolmanagementsystem.controller;

import com.betulsahin.schoolmanagementsystem.model.Course;
import com.betulsahin.schoolmanagementsystem.model.Student;
import com.betulsahin.schoolmanagementsystem.service.StudentService;

import java.util.List;

public class StudentController {
    private StudentService studentService = new StudentService();

    public Student getStudent(Long id){
        return studentService.findById(id);
    }

    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    public void createStudent(Student student){
        studentService.save(student);
    }

    public void updateStudent(Student student,Long id){
        studentService.update(student, id);
    }

    public void deleteStudent(Long id){
        studentService.deleteById(id);
    }

    public List<Course> getCoursesOfStudent(Long studentId){
        return studentService.findCoursesOfStudent(studentId);
    }
}
