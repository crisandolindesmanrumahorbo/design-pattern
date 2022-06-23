package com.rumahorbo.app.creational.abstractfactory;

public class Iphone5Earphone implements Earphone {

    @Override
    public String generateStartupSound() {
        return ("bark bark show Iphone logo ...");
    }
}
