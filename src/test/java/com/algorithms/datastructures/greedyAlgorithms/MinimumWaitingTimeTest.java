package com.algorithms.datastructures.greedyAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinimumWaitingTimeTest {
    @Test
    public void TestCase1() {
        int[] queries = new int[]{3, 2, 1, 2, 6};
        int expected = 17;
        var actual = new MinimumWaitingTime().minimumWaitingTime(queries);
        assertTrue(actual == expected);
    }
}
