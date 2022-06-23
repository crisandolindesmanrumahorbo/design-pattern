package com.rumahorbo.app.creational.abstractfactory;

public class PocophoneFactory implements PhoneSparePartsFactory {
    @Override
    public Charger createCharger() {
        return new PocophoneCharger();
    }

    @Override
    public Earphone createEarphone() {
        return new PocophoneEarphone();
    }
}
