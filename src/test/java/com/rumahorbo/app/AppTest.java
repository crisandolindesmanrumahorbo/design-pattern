package com.rumahorbo.app;

import com.rumahorbo.app.creational.abstractfactory.*;
import com.rumahorbo.app.creational.factory.Car;
import com.rumahorbo.app.creational.factory.Ship;
import com.rumahorbo.app.creational.factory.Vehicle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void startEngine_factory_pattern() {
        Vehicle car = new Car();

        assertEquals("Motor goes brom brom brom ...", car.startEngine());
    }

    @Test
    public void stopEngine_factory_pattern() {
        Vehicle ship = new Ship();

        assertEquals("Motor goes tik kitik kitik ...", ship.stopEngine());
    }

    @Test
    public void charge_abstract_factory() {
        PhoneSparePartsFactory phoneSparePartsFactory = new Iphone5Factory();
        Charger charger = phoneSparePartsFactory.createCharger();

        String actual = charger.charge();

        assertEquals("Lightning type charger", actual);
    }

    @Test
    public void generateStartupSound_abstract_factory() {
        PhoneSparePartsFactory phoneSparePartsFactory = new PocophoneFactory();
        Earphone earphone = phoneSparePartsFactory.createEarphone();

        String actual = earphone.generateStartupSound();

        assertEquals("meong meong show MIUI ...", actual);
    }
}
