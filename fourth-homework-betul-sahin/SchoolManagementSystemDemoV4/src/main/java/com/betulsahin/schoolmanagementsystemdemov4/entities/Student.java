package com.betulsahin.schoolmanagementsystemdemov4.entities;

import com.betulsahin.schoolmanagementsystemdemov4.entities.abtraction.AbstractBaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Student extends AbstractBaseEntity {
    private String name;
    private LocalDate birthdate;
    private String address;
    private String gender;

    // @JsonManagedReference (Status 415 hatasindan dolayi silindi.)
    @JsonIgnore
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private Set<CourseRegistration> registrations = new HashSet<>();

    public Student(String name, LocalDate birthdate, String address, String gender) {
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
        this.gender = gender;
    }
}

// TODO @JsonManagedReference test et