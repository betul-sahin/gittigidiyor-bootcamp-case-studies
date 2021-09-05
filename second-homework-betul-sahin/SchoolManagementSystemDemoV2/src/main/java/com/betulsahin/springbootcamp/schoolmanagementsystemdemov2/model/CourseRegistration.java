package com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class CourseRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate registeredAt;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    public CourseRegistration(LocalDate registeredAt) {
        this.registeredAt = registeredAt;
    }

    public CourseRegistration() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDate registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseRegistration that = (CourseRegistration) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CourseRegistration{" +
                "id=" + id +
                ", registeredAt=" + registeredAt +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
