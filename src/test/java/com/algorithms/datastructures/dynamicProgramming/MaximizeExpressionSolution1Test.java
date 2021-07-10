package com.algorithms.datastructures.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaximizeExpressionSolution1Test {
    @Test
    public void TestCase1() {
        int[] input = new int[] {3, 6, 1, -3, 2, 7};
        int expected = 4;
        var actual = new MaximizeExpressionSolution1().maximizeExpression(input);
        assertTrue(expected == actual);
    }
}
