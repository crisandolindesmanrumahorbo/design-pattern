package com.rumahorbo.app.structural.composite;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Developer implements Kroco, Employee {

    @Override
    public int getSalary() {
        return 5;
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
