package com.algorithms.datastructures.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SmallestDifferenceTest {
    @Test
    public void smallestDifference_returnPair() {
        assertArrayEquals(new int[]{28,26},
                SmallestDifference.smallestDifference(new int[]{-1,5,10,20,28,3}, new int[]{26,134,135,15,17}));
    }
}
