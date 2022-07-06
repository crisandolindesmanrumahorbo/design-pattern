package com.rumahorbo.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void recursive() {
        int sum = 0;
        int[] inputs = {1, 2, 3, 5, 11};
        int length = inputs.length;

        int actual = solve(sum, inputs, length - 1);

        assertEquals(22, actual);
    }

    private int solve(int sum, int[] inputs, int lastIndex) {
        sum += inputs[lastIndex];
        if (lastIndex == 0) {
            return sum;
        }
        lastIndex--;
        return solve(sum, inputs, lastIndex);
    }
}
