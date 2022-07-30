package com.rumahorbo.app.behavior.strategy;

import com.rumahorbo.app.behavior.strategy.model.Robot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class StrategyPatternTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void advance_strategy_pattern() {
        String currentPosition = "00E";
        String instructions = "AAR";

        Robot robot = new Robot();
        robot.processInstruction(currentPosition, instructions);

        assertEquals("2 0 S", robot.toString());
    }

    @Test
    public void turnLeft_strategy_pattern() {
        String currentPosition = "00E";
        String instructions = "ALL";

        Robot robot = new Robot();
        robot.processInstruction(currentPosition, instructions);

        assertEquals("1 0 W", robot.toString());
    }

    @Test
    public void turnRight_strategy_pattern() {
        String currentPosition = "11E";
        String instructions = "RRRAR";

        Robot robot = new Robot();
        robot.processInstruction(currentPosition, instructions);

        assertEquals("1 2 E", robot.toString());
    }

}
