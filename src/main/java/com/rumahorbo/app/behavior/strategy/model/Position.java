package com.rumahorbo.app.behavior.strategy.model;

import com.rumahorbo.app.behavior.strategy.AdvanceStrategy;
import com.rumahorbo.app.behavior.strategy.Strategy;
import com.rumahorbo.app.behavior.strategy.TurnLeftStrategy;
import com.rumahorbo.app.behavior.strategy.TurnRightStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Position {
    private final CardinalDirection cardinalDirection;
    private final Coordinate coordinate;

    Position changePosition(List<Instruction> instructionList) {
        Position newPosition = this;
        for (Instruction instruction : instructionList) {
            if (instruction == Instruction.ADVANCE) {
                newPosition = handleAdvance(newPosition);
                continue;
            }
            if (instruction == Instruction.TURN_RIGHT) {
                newPosition = handleTurnRight(newPosition);
                continue;
            }
            if (instruction == Instruction.TURN_LEFT) {
                newPosition = handleTurnLeft(newPosition);
            }
        }
        return newPosition;
    }

    private Position handleTurnLeft(Position newPosition) {
        Strategy strategy = new TurnLeftStrategy(newPosition.getCoordinate(), newPosition.getCardinalDirection());
        return strategy.changePosition();
    }

    private Position handleTurnRight(Position newPosition) {
        Strategy strategy = new TurnRightStrategy(newPosition.getCoordinate(), newPosition.getCardinalDirection());
        return strategy.changePosition();
    }

    private Position handleAdvance(Position newPosition) {
        Strategy strategy = new AdvanceStrategy(newPosition.getCoordinate(), newPosition.getCardinalDirection());
        return strategy.changePosition();
    }

    @Override
    public String toString() {
        return this.coordinate.toString() + " "
                + this.cardinalDirection.getValue();
    }
}
