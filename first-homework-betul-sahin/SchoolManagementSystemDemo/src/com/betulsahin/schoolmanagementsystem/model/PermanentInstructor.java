package com.betulsahin.schoolmanagementsystem.model;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class PermanentInstructor extends Instructor{
    private double salary;

    public PermanentInstructor(Long id, String name, String address, String phoneNumber, double salary) {
        super(id, name, address, phoneNumber);
        this.salary = salary;
    }

    public PermanentInstructor() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermanentInstructor that = (PermanentInstructor) o;
        return Double.compare(that.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary);
    }

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "salary=" + salary +
                '}';
    }
}
