package com.rumahorbo.app;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void iterate_array_number() {
        Integer[] numbers = new Integer[]{8, 9, 9, 9, 9, 9};
        List<Integer> list = Arrays.asList(numbers);
        StringBuilder actual = new StringBuilder();
        for (Integer number : result(list, 1)) {
            actual.append(number);
        }

        assertEquals("900000", actual.toString());
    }

    @Test
    public void iterateZero_array_number() {
        Integer[] numbers = new Integer[]{9, 9, 9, 9, 9, 9};
        List<Integer> list = Arrays.asList(numbers);
        StringBuilder actual = new StringBuilder();
        for (Integer number : result(list, 1)) {
            actual.append(number);
        }

        assertEquals("000000", actual.toString());
    }

    public List<Integer> result(List<Integer> numbers, int idx) {
        int listSize = numbers.size();
        int currentIdx = listSize - idx;
        if (numbers.get(currentIdx) == 9) {
            numbers.set(currentIdx, 0);
            if (currentIdx == 0) {
                return numbers;
            }
            idx++;
            return result(numbers, idx);
        }
        numbers.set(currentIdx, numbers.get(currentIdx) + 1);
        return numbers;
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
