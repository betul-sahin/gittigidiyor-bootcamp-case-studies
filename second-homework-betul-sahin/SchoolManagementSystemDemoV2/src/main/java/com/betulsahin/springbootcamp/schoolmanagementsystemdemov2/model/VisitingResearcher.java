package com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
@JsonTypeName("visitingResearcher")
public class VisitingResearcher extends Instructor {
    private int monthlyWorkingHours;
    private double hourlyRate;

    public VisitingResearcher(String name, String address, String phoneNumber, int monthlyWorkingHours, double hourlyRate) {
        super(name, address, phoneNumber);
        this.monthlyWorkingHours = monthlyWorkingHours;
        this.hourlyRate = hourlyRate;
    }

    public VisitingResearcher() {
    }

    public int getMonthlyWorkingHours() {
        return monthlyWorkingHours;
    }

    public void setMonthlyWorkingHours(int monthlyWorkingHours) {
        this.monthlyWorkingHours = monthlyWorkingHours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitingResearcher that = (VisitingResearcher) o;
        return monthlyWorkingHours == that.monthlyWorkingHours && Double.compare(that.hourlyRate, hourlyRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthlyWorkingHours, hourlyRate);
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "monthlyWorkingHours=" + monthlyWorkingHours +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}
