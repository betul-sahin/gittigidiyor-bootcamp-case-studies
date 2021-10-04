package com.betulsahin.schoolmanagementsystem;

import com.betulsahin.schoolmanagementsystem.controller.StudentController;
import com.betulsahin.schoolmanagementsystem.model.*;
import com.betulsahin.schoolmanagementsystem.util.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;

public class Client {
    private static void loadTestData(){
        Student student1 = new Student(null, "Ahmet Yılmaz", LocalDate.of(1990, Month.JANUARY,5), "Adana", GenderType.MALE);
        Student student2 = new Student(null, "Ayse Yılmaz", LocalDate.of(1994, Month.MARCH,20), "Ankara", GenderType.FEMALE);
        Student student3 = new Student(null, "Veli Yılmaz", LocalDate.of(1991, Month.NOVEMBER,15), "İstanbul", GenderType.MALE);
        Student student4 = new Student(null, "Nuran Yılmaz", LocalDate.of(1998, Month.APRIL,7), "Edirne", GenderType.FEMALE);
        Student student5 = new Student(null, "Zeynep Yılmaz", LocalDate.of(1995, Month.JUNE,22), "İzmir", GenderType.MALE);

        Course course1 = new Course(null, "Bilgi Teknolojilerine Giriş", "btk1000", 100);
        Course course2 = new Course(null, "JAVA İle Programlamaya Giriş", "btk1001", 100);
        Course course3 = new Course(null, "Python ile Makine Öğrenmesi", "btk1002", 100);
        Course course4 = new Course(null, "Doğal Dil İşlemeye Giriş", "btk1003", 100);
        Course course5 = new Course(null, "Algoritma, Programlama ve Veri Yapıları", "btk1004", 100);
        Course course6 = new Course(null, "HTML5 ile Web Geliştirme", "btk1005", 100);
        Course course7 = new Course(null, "Büyük Veriye Giriş", "btk1006", 100);
        Course course8 = new Course(null, "Uygulamalarla SQL Öğreniyorum", "btk1007", 100);

        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        student2.getCourses().add(course3);
        student2.getCourses().add(course2);
        student2.getCourses().add(course4);
        student4.getCourses().add(course6);
        student4.getCourses().add(course7);
        student4.getCourses().add(course8);
        student5.getCourses().add(course1);
        student5.getCourses().add(course5);
        student5.getCourses().add(course7);

        Instructor instructor1 = new VisitingResearcher(null, "Şadi Evren Şeker", "İstanbul", "05554331256", 40, 250.0);
        Instructor instructor2 = new PermanentInstructor(null, "Engin Demiroğ", "Ankara", "05554331256", 10000.0);
        Instructor instructor3 = new PermanentInstructor(null, "Uras Mutlu", "İstanbul", "05554331256", 10000.0);
        Instructor instructor4 = new VisitingResearcher(null, "Gizem Gezici", "Ankara", "05554331256", 40, 250.0);
        Instructor instructor5 = new VisitingResearcher(null, "Zafer Cömert", "İzmir", "05554331256", 40, 250.0);
        Instructor instructor6 = new PermanentInstructor(null, "Fahrettin Erdinç", "İstanbul", "05554331256", 10000);
        Instructor instructor7 = new PermanentInstructor(null, "Talha Kılıç", "Ankara", "05554331256", 10000);
        Instructor instructor8 = new PermanentInstructor(null, "Ömer Faruk Çolakoğlu", "İstanbul", "05554331256", 10000);

        instructor1.getCourses().add(course1);
        instructor5.getCourses().add(course2);
        instructor6.getCourses().add(course3);
        instructor2.getCourses().add(course6);
        instructor2.getCourses().add(course7);
        instructor2.getCourses().add(course8);
        instructor4.getCourses().add(course4);
        instructor7.getCourses().add(course5);

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor5);
        course3.setInstructor(instructor6);
        course6.setInstructor(instructor2);
        course7.setInstructor(instructor2);
        course8.setInstructor(instructor2);
        course4.setInstructor(instructor4);
        course5.setInstructor(instructor7);

        EntityManager manager = EntityManagerUtil.getEntityManager("mysqlPU");
        try{
            manager.getTransaction().begin();

            manager.persist(student1);
            manager.persist(student2);
            manager.persist(student3);
            manager.persist(student4);
            manager.persist(student5);

            manager.persist(course1);
            manager.persist(course2);
            manager.persist(course3);
            manager.persist(course4);
            manager.persist(course5);
            manager.persist(course6);
            manager.persist(course7);
            manager.persist(course8);

            manager.persist(instructor1);
            manager.persist(instructor2);
            manager.persist(instructor3);
            manager.persist(instructor4);
            manager.persist(instructor5);
            manager.persist(instructor6);
            manager.persist(instructor7);
            manager.persist(instructor8);

            manager.getTransaction().commit();
        }catch (Exception e){
            manager.getTransaction().rollback();
        }finally {
            EntityManagerUtil.closeEntityManager(manager);
        }
    }

    private static int checkTestData(){
        EntityManager manager = EntityManagerUtil.getEntityManager("mysqlPU");
        return manager.createQuery("from Student", Student.class)
                .getResultList().size();
    }

    public static void main(String[] args) {
        if(checkTestData() == 0){
            loadTestData();
        }

        // Yeni ogrenci kaydinin olusturulmasi.
       /*
        StudentController studentApi = new StudentController();

        Student newStudent = new Student(null, "Nevin Yeni", LocalDate.of(1980, Month.MARCH,5), "Adana", GenderType.FEMALE);
        studentApi.createStudent(newStudent);

        System.out.println("Kayit basariyla gerceklesti.");
        System.out.println("Yeni ogrenci: " + studentApi.getStudent(newStudent.getId()).toString());
        System.out.println();

        */

        // Mevcut ogrencinin bilgilerinin guncellenmesi
        /*
        StudentController studentApi = new StudentController();
        Student updatedStudent = newStudent;
        updatedStudent.setName(newStudent.getName() + " guncellendi");
        studentApi = new StudentController();
        studentApi.updateStudent(updatedStudent, updatedStudent.getId());

        System.out.println("Guncellenen ogrenci: " + studentApi.getStudent(updatedStudent.getId()).toString());
        System.out.println();

         */

        // Ogrenci kaydinin silinmesi
        /*
        StudentController studentApi = new StudentController();
        String deletedStudentName = studentApi.getStudent(1L).getName();
        studentApi.deleteStudent(1L);
        System.out.println(deletedStudentName + " isimli kayit basariyla silindi!");
        System.out.println();

         */

        /*
        StudentController studentApi = new StudentController();
        System.out.println("Kayitli Ogrenciler: ");
        studentApi.getAllStudents()
                .stream()
                .forEach(System.out::println);
        System.out.println();

         */

        // Ogrencinin almis oldugu kurslarin listelenmesi

        StudentController studentApi = new StudentController();
        System.out.println(studentApi.getStudent(2L).getName() + " isimli ogrencinin almis oldugu kurslar: ");
        studentApi.getCoursesOfStudent(2L)
                        .stream()
                        .forEach(System.out::println);


    }
}
