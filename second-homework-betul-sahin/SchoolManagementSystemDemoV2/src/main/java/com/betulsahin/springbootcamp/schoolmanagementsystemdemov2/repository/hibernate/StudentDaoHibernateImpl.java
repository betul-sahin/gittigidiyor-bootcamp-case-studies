package com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.repository.hibernate;

import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model.Instructor;
import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model.Student;
import com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.repository.CrudRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDaoHibernateImpl implements CrudRepository<Student> {

    private EntityManager entityManager;

    public StudentDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Student", Student.class)
                .getResultList();
    }

    @Override
    public Student findById(Long id) {
        return null;
    }

    @Override
    public Student save(Student student) {
        Session session = entityManager.unwrap(Session.class);
        return (Student) session.merge(student);
    }

    @Override
    public Student update(Student student) {
        Session session = entityManager.unwrap(Session.class);
        return (Student) session.merge(student);
    }

    @Override
    public void deleteById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Student student = session.get(Student.class, id);
        session.remove(student);
    }
}
