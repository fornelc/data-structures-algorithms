package com.algorithms.datastructures.arrays.sortedSquaredArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortedSquaredArraySolution1Test {
    @Test
    public void TestCase1() {
        var input = new int[] {1, 2, 3, 5, 6, 8, 9};
        var expected = new int[] {1, 4, 9, 25, 36, 64, 81};
        var actual = new SortedSquaredArraySolution1().sortedSquaredArray(input);
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }
}
