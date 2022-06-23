package com.rumahorbo.app.creational.builder;

import lombok.Getter;

@Getter
public class GeneralComputer implements Computer {
    private CPU cpu;
    private Monitor monitor;
    private Keyboard keyboard;
    private Mouse mouse;

    @Override
    public void setCPU(CPU cpu) {
        this.cpu = cpu;
    }

    @Override
    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    @Override
    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
