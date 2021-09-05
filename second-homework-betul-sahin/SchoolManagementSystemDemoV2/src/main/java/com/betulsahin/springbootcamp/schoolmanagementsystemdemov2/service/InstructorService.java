package com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.service;

import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model.Instructor;
import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InstructorService implements BaseService<Instructor> {
    private CrudRepository instructorDaoJpa;

    public InstructorService(@Qualifier("instructorDaoJpaImpl") CrudRepository instructorDaoJpa) {
        this.instructorDaoJpa = instructorDaoJpa;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorDaoJpa.findAll();
    }

    @Override
    public Instructor findById(Long id) {
        return (Instructor) instructorDaoJpa.findById(id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return (Instructor) instructorDaoJpa.save(instructor);
    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor) {
        return (Instructor) instructorDaoJpa.update(instructor);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        instructorDaoJpa.deleteById(id);
    }
}
