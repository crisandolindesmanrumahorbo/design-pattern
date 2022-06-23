package com.rumahorbo.app.creational.abstractfactory;

public interface PhoneSparePartsFactory {
    Charger createCharger();
    Earphone createEarphone();
}
