package com.rumahorbo.app.behavior.strategy.model;

public enum CardinalDirection {
    EAST("E"),
    SOUTH("S"),
    WEST("W"),
    NORTH("N");

    final String value;

    CardinalDirection(String value) {
        this.value = value;
    }

    public static CardinalDirection parseCardinalDirection(char direction) {
        if (direction == 'N') {
            return CardinalDirection.NORTH;
        }
        if (direction == 'E') {
            return CardinalDirection.EAST;
        }
        if (direction == 'S') {
            return CardinalDirection.SOUTH;
        }
        return CardinalDirection.WEST;
    }

    public String getValue() {
        return this.value;
    }

    public CardinalDirection turnRight() {
        int turnRightOrdinal = this.ordinal() + 1;
        if (turnRightOrdinal == 4) {
            turnRightOrdinal = 0;
        }
        return CardinalDirection.values()[turnRightOrdinal];
    }

    public CardinalDirection turnLeft() {
        int turnRightOrdinal = this.ordinal() - 1;
        if (turnRightOrdinal == -1) {
            turnRightOrdinal = 3;
        }
        return CardinalDirection.values()[turnRightOrdinal];
    }
}
