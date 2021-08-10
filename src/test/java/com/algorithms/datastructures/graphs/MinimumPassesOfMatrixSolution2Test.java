package com.algorithms.datastructures.graphs;

import org.junit.jupiter.api.Test;

public class MinimumPassesOfMatrixSolution2Test {
    @Test
    public void TestCase1() {
        int[][] matrix = new int[][] {{0, -1, -3, 2, 0}, {1, -2, -5, -1, -3}, {3, 0, 0, -4, -1}};
        int expected = 3;
        int actual = new MinimumPassesOfMatrixSolution2().minimumPassesOfMatrix(matrix);
        assert (expected == actual);
    }
}
