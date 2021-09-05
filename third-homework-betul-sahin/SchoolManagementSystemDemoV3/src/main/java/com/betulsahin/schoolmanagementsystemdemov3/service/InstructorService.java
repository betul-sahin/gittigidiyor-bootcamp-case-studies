package com.betulsahin.schoolmanagementsystemdemov3.service;

import com.betulsahin.schoolmanagementsystemdemov3.entity.Instructor;
import com.betulsahin.schoolmanagementsystemdemov3.exception.InstrustorNotFound;
import com.betulsahin.schoolmanagementsystemdemov3.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InstructorService implements BaseService<Instructor> {
    private static final String INSTRUCTOR_NOT_FOUND = "Instructor not found with this id : ";

    private final InstructorRepository instructorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Instructor> findAll() {
        List<Instructor> instructors = new ArrayList<>();
        instructorRepository.findAll()
                .iterator()
                .forEachRemaining(instructors::add);

        return instructors;
    }

    @Transactional(readOnly = true)
    public List<Instructor> findAllByNameContaining(String searchWord) {
        List<Instructor> instructors = new ArrayList<>();
        instructorRepository.findAllByNameContainingIgnoreCase(searchWord)
                .iterator()
                .forEachRemaining(instructors::add);

        return instructors;
    }

    @Transactional(readOnly = true)
    public List<?> findAllTop3BySalaryGreaterThan(){
        List<Object> instructors = new ArrayList<>();
        instructorRepository.findAllTop3BySalaryGreaterThan()
                .iterator()
                .forEachRemaining(instructors::add);

        return instructors;
    }

    @Override
    @Transactional(readOnly = true)
    public Instructor findById(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new InstrustorNotFound(
                        String.format(INSTRUCTOR_NOT_FOUND, id)));
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        instructorRepository.deleteById(id);
    }

    @Transactional
    public void deleteByName(String name) {
        instructorRepository.deleteByName(name);
    }
}
