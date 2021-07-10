package com.algorithms.datastructures.dynamicProgramming.numberOfWaysToTraverseGraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberOfWaysToTraverseGraphSolution2Test {
    @Test
    public void TestCase1() {
        int width = 4;
        int height = 3;
        int expected = 10;
        var actual = new NumberOfWaysToTraverseGraphSolution2().numberOfWaysToTraverseGraph(width, height);
        assertTrue(expected == actual);
    }
}
