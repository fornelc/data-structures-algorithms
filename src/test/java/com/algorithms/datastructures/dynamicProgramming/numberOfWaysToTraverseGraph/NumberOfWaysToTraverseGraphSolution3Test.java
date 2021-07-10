package com.algorithms.datastructures.dynamicProgramming.numberOfWaysToTraverseGraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberOfWaysToTraverseGraphSolution3Test {
    @Test
    public void TestCase1() {
        int width = 4;
        int height = 3;
        int expected = 10;
        var actual = new NumberOfWaysToTraverseGraphSolution3().numberOfWaysToTraverseGraph(width, height);
        assertTrue(expected == actual);
    }
}
