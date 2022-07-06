package com.rumahorbo.app.structural.composite;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ScrumMaster implements Manager, Employee {

    @Override
    public int getSalary() {
        return 10;
    }

    @Override
    public int getSubordinateSalaries() {
        return 0;
    }

    @Override
    public Employee getEmployee() {
        return this;
    }
}
