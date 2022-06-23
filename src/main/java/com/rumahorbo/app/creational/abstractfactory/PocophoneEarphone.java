package com.rumahorbo.app.creational.abstractfactory;

public class PocophoneEarphone implements Earphone {
    @Override
    public String generateStartupSound() {
        return ("meong meong show MIUI ...");
    }
}
