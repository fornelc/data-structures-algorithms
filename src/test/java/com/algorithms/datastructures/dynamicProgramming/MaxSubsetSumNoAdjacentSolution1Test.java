package com.algorithms.datastructures.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaxSubsetSumNoAdjacentSolution1Test {
    @Test
    public void TestCase1() {
        int[] input = {75, 105, 120, 75, 90, 135};
        assertTrue(MaxSubsetSumNoAdjacentSolution1.maxSubsetSumNoAdjacent(input) == 330);
    }
}
