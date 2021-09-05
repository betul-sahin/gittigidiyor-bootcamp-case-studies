package com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.repository.jpa;

import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model.Student;
import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentDaoJpaImpl implements CrudRepository<Student> {
    private EntityManager entityManager;

    @Autowired
    public StudentDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("from Student", Student.class)
                .getResultList();
    }

    @Override
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
