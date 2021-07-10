package com.algorithms.datastructures.arrays.minRewards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinRewardsSolution2Test {
    @Test
    public void TestCase1() {
        assertTrue(MinRewardsSolution2.minRewards(new int[] {8, 4, 2, 1, 3, 6, 7, 9, 5}) == 25);
    }
}
