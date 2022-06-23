package com.rumahorbo.app.creational.abstractfactory;

public class Iphone5Factory implements PhoneSparePartsFactory {
    @Override
    public Charger createCharger() {
        return new Iphone5Charger();
    }

    @Override
    public Earphone createEarphone() {
        return new Iphone5Earphone();
    }
}
