package com.algorithms.datastructures.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WaterAreaSolution1Test {
    @Test
    public void TestCase1() {
        int[] input = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        assertTrue(WaterAreaSolution1.waterArea(input) == 48);
    }

    @Test
    public void TestCase2() {
        int[] input = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        assertTrue(WaterAreaSolution1.waterArea2(input) == 48);
    }
}
