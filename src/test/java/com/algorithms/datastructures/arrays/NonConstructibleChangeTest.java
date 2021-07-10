package com.algorithms.datastructures.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NonConstructibleChangeTest {
    @Test
    public void TestCase1() {
        int[] input = new int[] {5, 7, 1, 1, 2, 3, 22};
        int expected = 20;
        var actual = new NonConstructibleChange().nonConstructibleChange(input);
        assertTrue(expected == actual);
    }
}
