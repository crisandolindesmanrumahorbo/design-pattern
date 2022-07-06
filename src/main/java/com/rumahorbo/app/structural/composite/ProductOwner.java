package com.rumahorbo.app.structural.composite;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductOwner implements Manager, Employee {
    private final Kroco[] krocos;

    @Override
    public int getSalary() {
        return 10;
    }

    @Override
    public int getSubordinateSalaries() {
        int sum = 0;
        for (Kroco kroco : krocos) {
            sum += kroco.getEmployee().getSubordinateSalaries();
        }
        return sum;
    }

    @Override
    public Employee getEmployee() {
        return this;
    }
}
