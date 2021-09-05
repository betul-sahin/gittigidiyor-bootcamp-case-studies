package com.betulsahin.schoolmanagementsystemdemov3.service;

import com.betulsahin.schoolmanagementsystemdemov3.entity.Student;
import com.betulsahin.schoolmanagementsystemdemov3.exception.StudentNotFoundException;
import com.betulsahin.schoolmanagementsystemdemov3.repository.StudentGenderStatistics;
import com.betulsahin.schoolmanagementsystemdemov3.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService implements BaseService<Student>{
    private static final String STUDENT_NOT_FOUND = "Student not found with this id : " ;

    private final StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll()
                .iterator()
                .forEachRemaining(students::add);

        return students;
    }

    @Transactional(readOnly = true)
    public List<Student> findAllByNameContaining(String searchWord) {
        List<Student> students = new ArrayList<>();
        studentRepository.findAllByNameContainingIgnoreCase(searchWord)
                .iterator()
                .forEachRemaining(students::add);

        return students;
    }

    @Transactional(readOnly = true)
    public List<?> findAllByGendersWithGrouping() {
        List<StudentGenderStatistics> students = new ArrayList<>();
        studentRepository.findAllByGendersWithGrouping()
                .iterator()
                .forEachRemaining(students::add);

        return students;
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(
                        String.format(STUDENT_NOT_FOUND, id)));
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public void deleteByName(String name) {
        studentRepository.deleteByName(name);
    }
}
