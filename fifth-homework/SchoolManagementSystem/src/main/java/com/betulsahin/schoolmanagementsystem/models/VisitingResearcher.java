package com.betulsahin.schoolmanagementsystem.models;

import com.betulsahin.schoolmanagementsystem.models.abstracts.Instructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class VisitingResearcher extends Instructor {
    private double hourlySalary;

    public VisitingResearcher(String name, String address,
                              String phoneNumber, double hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    @Override
    public double getSalary() {
        return hourlySalary;
    }
}
