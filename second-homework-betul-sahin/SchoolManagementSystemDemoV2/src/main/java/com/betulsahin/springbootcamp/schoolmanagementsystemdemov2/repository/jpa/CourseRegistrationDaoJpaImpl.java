package com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.repository.jpa;

import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model.CourseRegistration;
import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CourseRegistrationDaoJpaImpl implements CrudRepository<CourseRegistration> {
    private EntityManager entityManager;

    @Autowired
    public CourseRegistrationDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CourseRegistration> findAll() {
        return entityManager.createQuery("from CourseRegistration", CourseRegistration.class)
                .getResultList();
    }

    @Override
    public CourseRegistration findById(Long id) {
        return entityManager.find(CourseRegistration.class, id);
    }

    @Override
    @Transactional
    public CourseRegistration save(CourseRegistration courseRegistration) {
        return entityManager.merge(courseRegistration);
    }

    @Override
    @Transactional
    public CourseRegistration update(CourseRegistration courseRegistration) {
        return entityManager.merge(courseRegistration);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        CourseRegistration courseRegistration = entityManager.find(CourseRegistration.class, id);
        entityManager.remove(courseRegistration);
    }
}
