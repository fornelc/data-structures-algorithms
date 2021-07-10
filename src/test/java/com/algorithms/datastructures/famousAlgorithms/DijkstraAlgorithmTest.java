package com.algorithms.datastructures.famousAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DijkstraAlgorithmTest {
    @Test
    public void TestCase1() {
        int start = 0;
        int[][][] edges = {
                {{1, 7}},
                {{2, 6}, {3, 20}, {4, 3}},
                {{3, 14}},
                {{4, 2}},
                {},
                {}
        };
        int[] expected = {0, 7, 13, 27, 10, -1};
        int[] actual = new DijkstraAlgorithm().dijkstrasAlgorithm(start, edges);
        assertTrue(expected.length == actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }
}
