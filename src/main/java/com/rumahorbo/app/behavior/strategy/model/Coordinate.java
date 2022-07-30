package com.rumahorbo.app.behavior.strategy.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Coordinate {
    private final int xAxis;
    private final int yAxis;

    public Coordinate advance(CardinalDirection cardinalDirection) {
        if (cardinalDirection == CardinalDirection.EAST) {
            return new Coordinate(xAxis + 1, yAxis);
        }
        if (cardinalDirection == CardinalDirection.SOUTH) {
            return new Coordinate(xAxis, yAxis - 1);
        }
        if (cardinalDirection == CardinalDirection.WEST) {
            return new Coordinate(xAxis - 1, yAxis);
        }
        return new Coordinate(xAxis, yAxis + 1);
    }

    @Override
    public String toString() {
        return this.xAxis + " " + this.yAxis;
    }
}
