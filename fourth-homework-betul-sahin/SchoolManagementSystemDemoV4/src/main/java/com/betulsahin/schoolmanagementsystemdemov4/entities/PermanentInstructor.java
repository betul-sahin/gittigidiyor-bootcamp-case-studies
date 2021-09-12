package com.betulsahin.schoolmanagementsystemdemov4.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class PermanentInstructor extends Instructor{
    private double salary;

    public PermanentInstructor(String name, String address,
                               String phoneNumber, double salary) {
        super(name, address, phoneNumber);
        this.salary = salary;
    }
}
