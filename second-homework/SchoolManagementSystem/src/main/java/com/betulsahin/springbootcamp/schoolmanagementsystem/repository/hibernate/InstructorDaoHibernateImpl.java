package com.betulsahin.springbootcamp.schoolmanagementsystem.repository.hibernate;

import com.betulsahin.springbootcamp.schoolmanagementsystem.model.Instructor;
import com.betulsahin.springbootcamp.schoolmanagementsystem.repository.CrudRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InstructorDaoHibernateImpl implements CrudRepository<Instructor> {
    private EntityManager entityManager;

    public InstructorDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Instructor> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Instructor", Instructor.class)
                .getResultList();
    }

    @Override
    public Instructor findById(Long id) {
        return null;
    }

    @Override
    public Instructor save(Instructor instructor) {
        Session session = entityManager.unwrap(Session.class);
        return (Instructor) session.merge(instructor);
    }

    @Override
    public Instructor update(Instructor instructor) {
        Session session = entityManager.unwrap(Session.class);
        return (Instructor) session.merge(instructor);
    }

    @Override
    public void deleteById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Instructor instructor = session.get(Instructor.class, id);
        session.remove(instructor);
    }
}
