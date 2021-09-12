package com.betulsahin.schoolmanagementsystemdemov4.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class VisitingResearcher extends Instructor {
    private int monthlyWorkingHours;
    private double hourlyRate;

    public VisitingResearcher(String name, String address, String phoneNumber,
                              int monthlyWorkingHours, double hourlyRate) {
        super(name, address, phoneNumber);
        this.monthlyWorkingHours = monthlyWorkingHours;
        this.hourlyRate = hourlyRate;
    }
}
