package com.algorithms.datastructures.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CycleInGraphTest {
    @Test
    public void TestCase1() {
        int[][] input = new int[][] {
                {1, 3},
                {2, 3, 4},
                {0},
                {},
                {2, 5},
                {}
        };
        boolean expected = true;
        var actual = new CycleInGraph().cycleInGraph(input);
        assertTrue(expected == actual);
    }
}