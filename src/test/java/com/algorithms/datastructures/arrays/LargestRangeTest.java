package com.algorithms.datastructures.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LargestRangeTest {
    @Test
    public void TestCase1() {
        int[] expected = {0, 7};
        assertTrue(
                Arrays.equals(
                        LargestRange.largestRange(new int[] {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6}), expected));
    }
}
