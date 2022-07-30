package com.rumahorbo.app.behavior.strategy;

import com.rumahorbo.app.behavior.strategy.model.CardinalDirection;
import com.rumahorbo.app.behavior.strategy.model.Coordinate;
import com.rumahorbo.app.behavior.strategy.model.Position;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TurnRightStrategy implements Strategy {
    private final Coordinate coordinate;
    private final CardinalDirection cardinalDirection;

    @Override
    public Position changePosition() {
        CardinalDirection newCardinalDirection = this.cardinalDirection.turnRight();
        return new Position(newCardinalDirection, this.coordinate);
    }
}
