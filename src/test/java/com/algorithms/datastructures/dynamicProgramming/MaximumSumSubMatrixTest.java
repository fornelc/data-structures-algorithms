package com.algorithms.datastructures.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaximumSumSubMatrixTest {
    @Test
    public void TestCase1() {
        int[][] matrix = new int[][] {{5, 3, -1, 5}, {-7, 3, 7, 4}, {12, 8, 0, 0}, {1, -8, -8, 2}};
        int size = 2;
        int expected = 18;
        var actual = new MaximumSumSubMatrix().maximumSumSubmatrix(matrix, size);
        assertTrue(expected == actual);
    }
}
