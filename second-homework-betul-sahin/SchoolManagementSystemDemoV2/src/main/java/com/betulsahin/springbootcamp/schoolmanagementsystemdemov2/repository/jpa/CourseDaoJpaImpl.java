package com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.repository.jpa;

import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model.Course;
import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CourseDaoJpaImpl implements CrudRepository<Course> {
    private EntityManager entityManager;

    @Autowired
    public CourseDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("from Course", Course.class)
                .getResultList();
    }

    @Override
    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return entityManager.merge(course);
    }

    @Override
    @Transactional
    public Course update(Course course) {
        return entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
