package com.betulsahin.schoolmanagementsystem.models;

import com.betulsahin.schoolmanagementsystem.models.abstracts.Instructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class PermanentInstructor extends Instructor {
    private double fixedSalary;

    public PermanentInstructor(String name, String address,
                               String phoneNumber, double fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double getSalary() {
        return fixedSalary;
    }
}
