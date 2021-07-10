package com.algorithms.datastructures.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinNumberOfJumpsSolution2Test {
    @Test
    public void TestCase1() {
        int[] input = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        assertTrue(MinNumberOfJumpsSolution2.minNumberOfJumps(input) == 4);
    }

    @Test
    public void TestCase2() {
        int[] input = {1, 1};
        assertTrue(MinNumberOfJumpsSolution2.minNumberOfJumps(input) == 1);
    }
}
