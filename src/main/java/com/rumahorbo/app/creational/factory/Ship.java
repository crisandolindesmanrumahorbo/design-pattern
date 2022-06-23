package com.rumahorbo.app.creational.factory;

public class Ship implements Vehicle {
    @Override
    public String startEngine() {
        return "Motor goes tek ketek ketek ...";
    }

    @Override
    public String stopEngine() {
        return "Motor goes tik kitik kitik ...";
    }
}
