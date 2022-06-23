package com.rumahorbo.app.creational.factory;

public class Car implements Vehicle {
    @Override
    public String startEngine() {
        return "Motor goes brom brom brom ...";
    }

    @Override
    public String stopEngine() {
        return "Motor goes bram bram bram ...";
    }
}
