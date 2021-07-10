package com.algorithms.datastructures.arrays.firstDuplicateValue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstDuplicateValueSolution1Test {
    @Test
    public void TestCase1() {
        var input = new int[] {2, 1, 5, 2, 3, 3, 4};
        var expected = 2;
        var actual = new FirstDuplicateValueSolution1().firstDuplicateValue(input);
        assertTrue(expected == actual);
    }
}
