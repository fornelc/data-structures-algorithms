package com.algorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinMaxStackConstructionTest {
    public void testMinMaxPeek(int min, int max, int peek, MinMaxStackConstruction.MinMaxStack stack) {
        assertTrue(stack.getMin() == min);
        assertTrue(stack.getMax() == max);
        assertTrue(stack.peek() == peek);
    }

    @Test
    public void TestCase1() {
        MinMaxStackConstruction.MinMaxStack stack = new MinMaxStackConstruction.MinMaxStack();
        stack.push(5);
        testMinMaxPeek(5, 5, 5, stack);
        stack.push(7);
        testMinMaxPeek(5, 7, 7, stack);
        stack.push(2);
        testMinMaxPeek(2, 7, 2, stack);
        assertTrue(stack.pop() == 2);
        assertTrue(stack.pop() == 7);
        testMinMaxPeek(5, 5, 5, stack);
    }
}
