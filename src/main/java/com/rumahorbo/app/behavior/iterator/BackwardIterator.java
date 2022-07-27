package com.rumahorbo.app.behavior.iterator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BackwardIterator implements Iterator {
    private final int[] numbers;
    private int currentIdx;

    @Override
    public int next() {
        int currentNumber = numbers[currentIdx];
        currentIdx--;
        return currentNumber;
    }

    @Override
    public boolean hasNext() {
        return currentIdx >= 0;
    }
}
