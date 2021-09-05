package com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.repository.hibernate;

import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model.Course;
import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.repository.CrudRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import sun.security.krb5.internal.EncTicketPart;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDaoHibernateImpl implements CrudRepository<Course> {
    private EntityManager entityManager;

    public CourseDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Course", Course.class)
                .getResultList();
    }

    @Override
    public Course findById(Long id) {
        return null;
    }

    @Override
    public Course save(Course course) {
        Session session = entityManager.unwrap(Session.class);
        return (Course) session.merge(course);
    }

    @Override
    public Course update(Course course) {
        Session session = entityManager.unwrap(Session.class);
        return (Course) session.merge(course);
    }

    @Override
    public void deleteById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Course course = session.get(Course.class, id);
        session.remove(course);
    }
}
