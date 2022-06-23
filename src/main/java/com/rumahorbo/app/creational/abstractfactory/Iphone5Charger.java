package com.rumahorbo.app.creational.abstractfactory;

public class Iphone5Charger implements Charger {
    @Override
    public String charge() {
        return "Lightning type charger";
    }
}
