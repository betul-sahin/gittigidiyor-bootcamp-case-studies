package com.betulsahin.schoolmanagementsystemdemov3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private int creditScore;

    // @JsonBackReference
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Instructor instructor;

    // @JsonBackReference
    @JsonIgnore
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private Set<CourseRegistration> registrations = new HashSet<>();

    public Course(String name, String code, int creditScore) {
        this.name = name;
        this.code = code;
        this.creditScore = creditScore;
    }
}
