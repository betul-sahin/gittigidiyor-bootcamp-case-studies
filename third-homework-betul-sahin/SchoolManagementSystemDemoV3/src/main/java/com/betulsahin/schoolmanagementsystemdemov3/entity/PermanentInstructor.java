package com.betulsahin.schoolmanagementsystemdemov3.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PERMANENTINSTRUCTOR")
@JsonTypeName("permanentInstructor")
public class PermanentInstructor extends Instructor{
    private double salary;

    public PermanentInstructor(String name, String address,
                               String phoneNumber, double salary) {
        super(name, address, phoneNumber);
        this.salary = salary;
    }
}
