package com.betulsahin.schoolmanagementsystemdemov3.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@JsonTypeName("visitingResearcher")
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
