package com.betulsahin.springbootcamp.schoolmanagementsystem.service;

import com.betulsahin.springbootcamp.schoolmanagementsystem.model.Student;
import com.betulsahin.springbootcamp.schoolmanagementsystem.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService implements BaseService<Student>{
    private CrudRepository studentDaoJpa;

    public StudentService(@Qualifier("studentDaoJpaImpl") CrudRepository studentDaoJpa) {
        this.studentDaoJpa = studentDaoJpa;
    }

    @Override
    public List<Student> findAll() {
        return studentDaoJpa.findAll();
    }

    @Override
    public Student findById(Long id) {
        return (Student) studentDaoJpa.findById(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return (Student) studentDaoJpa.save(student);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return (Student) studentDaoJpa.update(student);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        studentDaoJpa.deleteById(id);
    }
}
