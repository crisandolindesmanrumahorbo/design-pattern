package com.rumahorbo.app.behavior.strategy.model;

public enum Instruction {
    ADVANCE,
    TURN_RIGHT,
    TURN_LEFT;

    public static Instruction parseFromInput(char input) {
        if (input == 'A') {
            return Instruction.ADVANCE;
        }
        if (input == 'R') {
            return Instruction.TURN_RIGHT;
        }
        return Instruction.TURN_LEFT;
    }
}
