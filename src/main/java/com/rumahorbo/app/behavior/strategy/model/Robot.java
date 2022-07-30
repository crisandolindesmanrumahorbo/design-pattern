package com.rumahorbo.app.behavior.strategy.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Robot {
    private Position position;

    public void processInstruction(String currentLocation, String instructionsString) {
        currentLocation = currentLocation.trim().toUpperCase();
        instructionsString = instructionsString.trim().toUpperCase();
        int xAxis = Integer.parseInt(currentLocation.substring(0, 1));
        int yAxis = Integer.parseInt(currentLocation.substring(1, 2));
        CardinalDirection cardinalDirection = CardinalDirection.parseCardinalDirection(currentLocation.charAt(2));
        Coordinate coordinate = new Coordinate(xAxis, yAxis);
        List<Instruction> instructionList = new ArrayList<>();
        for (int i = 0; i < instructionsString.length(); i++) {
            char instruction = instructionsString.charAt(i);
            instructionList.add(Instruction.parseFromInput(instruction));
        }
        this.position = new Position(cardinalDirection, coordinate);

        this.position = this.position.changePosition(instructionList);
    }

    @Override
    public String toString() {
        return this.position.toString();
    }
}
