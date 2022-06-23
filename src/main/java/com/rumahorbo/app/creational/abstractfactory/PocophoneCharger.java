package com.rumahorbo.app.creational.abstractfactory;

public class PocophoneCharger implements Charger {
    @Override
    public String charge() {
        return ("Type c charger");
    }
}
