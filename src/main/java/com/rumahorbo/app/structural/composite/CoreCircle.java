package com.rumahorbo.app.structural.composite;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CoreCircle implements ServiceHead, Employee {
    private final Manager[] managers;

    @Override
    public int getSalary() {
        return 30;
    }

    @Override
    public int getSubordinateSalaries() {
        int sum = 0;
        for (Manager manager : managers) {
            sum += manager.getEmployee().getSubordinateSalaries() + manager.getEmployee().getSalary();
        }
        return sum;
    }

    @Override
    public int getServiceTotalSalary() {
        return getSalary() + getSubordinateSalaries();
    }
}
