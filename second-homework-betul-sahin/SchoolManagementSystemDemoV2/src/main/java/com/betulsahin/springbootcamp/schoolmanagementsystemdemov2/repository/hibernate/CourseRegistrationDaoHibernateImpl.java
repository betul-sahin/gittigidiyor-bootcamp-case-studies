package com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.repository.hibernate;

import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model.Course;
import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model.CourseRegistration;
import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.repository.CrudRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseRegistrationDaoHibernateImpl implements CrudRepository<CourseRegistration> {
    private EntityManager entityManager;

    public CourseRegistrationDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CourseRegistration> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from CourseRegistration", CourseRegistration.class)
                .getResultList();
    }

    @Override
    public CourseRegistration findById(Long id) {
        return null;
    }

    @Override
    public CourseRegistration save(CourseRegistration courseRegistration) {
        Session session = entityManager.unwrap(Session.class);
        return (CourseRegistration) session.merge(courseRegistration);
    }

    @Override
    public CourseRegistration update(CourseRegistration courseRegistration) {
        Session session = entityManager.unwrap(Session.class);
        return (CourseRegistration) session.merge(courseRegistration);
    }

    @Override
    public void deleteById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        CourseRegistration courseRegistration = session.get(CourseRegistration.class, id);
        session.remove(courseRegistration);
    }
}
