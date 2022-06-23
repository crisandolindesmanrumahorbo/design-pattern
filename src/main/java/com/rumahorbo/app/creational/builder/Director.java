package com.rumahorbo.app.creational.builder;

public class Director {

    public static GamingComputer constructGamingComputer() {
        GamingComputer gamingComputer = new GamingComputer();
        gamingComputer.setCPU(new GamingCPU());
        gamingComputer.setMonitor(new GamingMonitor());
        gamingComputer.setKeyboard(new Keyboard());
        gamingComputer.setMouse(new Mouse());
        return gamingComputer;
    }

    public static GeneralComputer constructGeneralComputer() {
        GeneralComputer generalComputer = new GeneralComputer();
        generalComputer.setCPU(new GeneralCPU());
        generalComputer.setMonitor(new GeneralMonitor());
        generalComputer.setKeyboard(new Keyboard());
        generalComputer.setMouse(new Mouse());
        return generalComputer;
    }
}
