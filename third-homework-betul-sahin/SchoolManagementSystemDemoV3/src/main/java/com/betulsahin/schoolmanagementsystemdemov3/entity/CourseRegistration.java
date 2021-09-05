package com.betulsahin.schoolmanagementsystemdemov3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
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
}
