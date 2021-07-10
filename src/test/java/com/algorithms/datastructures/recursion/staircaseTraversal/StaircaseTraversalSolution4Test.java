package com.algorithms.datastructures.recursion.staircaseTraversal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StaircaseTraversalSolution4Test {
    @Test
    public void TestCase1() {
        int stairs = 4;
        int maxSteps = 2;
        int expected = 5;
        int actual = new StaircaseTraversalSolution4().staircaseTraversal(stairs, maxSteps);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase2() {
        int stairs = 4;
        int maxSteps = 3;
        int expected = 7;
        int actual = new StaircaseTraversalSolution4().staircaseTraversal(stairs, maxSteps);
        assertTrue(expected == actual);
    }
}
