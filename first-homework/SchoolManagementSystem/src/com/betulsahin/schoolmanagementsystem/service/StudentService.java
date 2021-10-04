package com.betulsahin.schoolmanagementsystem.service;

import com.betulsahin.schoolmanagementsystem.model.Course;
import com.betulsahin.schoolmanagementsystem.model.Student;
import com.betulsahin.schoolmanagementsystem.repository.StudentRepository;
import com.betulsahin.schoolmanagementsystem.util.EntityManagerUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements StudentRepository {
    EntityManager entityManager = EntityManagerUtil.getEntityManager("mysqlPU");

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("from Student", Student.class)
                .getResultList();

        /**Session session = entityManager.unwrap(Session.class);
        List<Student> students = session.createQuery("from Student", Student.class)
                .getResultList();
        return students;
         **/
    }

    @Override
    public Student findById(Long id) {
        return entityManager
                .createQuery("from Student s where s.id=:studentId", Student.class)
                .setParameter("studentId", id)
                .getSingleResult();

        /**Session session = entityManager.unwrap(Session.class);
        Student student = session.get(Student.class, id);
        return student;
         **/
    }

    @Override
    public void save(Student student) {
        try{
         entityManager.getTransaction().begin();
         entityManager.persist(student);
         entityManager.getTransaction().commit();
        }catch (Exception e){
         entityManager.getTransaction().rollback();
        }finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }

        /**Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(student);
         **/
    }

    @Override
    public void update(Student student, Long id) {
        try{
            entityManager.getTransaction().begin();

            Student updatedStudent = entityManager.find(Student.class, id);
            updatedStudent.setAddress(student.getAddress());
            updatedStudent.setName(student.getName());
            updatedStudent.setBirthdate(student.getBirthdate());
            updatedStudent.setGender(student.getGender());
            entityManager.merge(updatedStudent);

            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }

        /**Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(student);
         **/
    }

    @Override
    public void deleteById(Long id) {
        try{
            entityManager.getTransaction().begin();

            Student student = entityManager.find(Student.class, id);
            entityManager.remove(student);

            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }

        /**Session session = entityManager.unwrap(Session.class);
        Student deletedStudent = session.get(Student.class, id);
        session.delete(deletedStudent);
         **/
    }

    @Override
    public List<Course> findCoursesOfStudent(Long studentId) {
        return findById(studentId).getCourses();
    }
}
