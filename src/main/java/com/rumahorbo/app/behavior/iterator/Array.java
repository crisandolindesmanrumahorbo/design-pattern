package com.rumahorbo.app.behavior.iterator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Array implements IterableCollection {
    private final boolean isBackward;
    private final int[] numbers;

    @Override
    public Iterator createIterator() {
        if (isBackward) {
            return new BackwardIterator(numbers, numbers.length - 1);
        }
        return new ForwardIterator(numbers, 0);
    }
}
