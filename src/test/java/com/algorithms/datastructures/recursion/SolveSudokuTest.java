package com.algorithms.datastructures.recursion;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolveSudokuTest {

    @Test
    public void TestCase1() {
        int[][] inputValues =
                new int[][] {
                        {7, 8, 0, 4, 0, 0, 1, 2, 0},
                        {6, 0, 0, 0, 7, 5, 0, 0, 9},
                        {0, 0, 0, 6, 0, 1, 0, 7, 8},
                        {0, 0, 7, 0, 4, 0, 2, 6, 0},
                        {0, 0, 1, 0, 5, 0, 9, 3, 0},
                        {9, 0, 4, 0, 6, 0, 0, 0, 5},
                        {0, 7, 0, 3, 0, 0, 0, 1, 2},
                        {1, 2, 0, 0, 0, 7, 4, 0, 0},
                        {0, 4, 9, 2, 0, 6, 0, 0, 7}
                };
        int[][] expectedValues =
                new int[][] {
                        {7, 8, 5, 4, 3, 9, 1, 2, 6},
                        {6, 1, 2, 8, 7, 5, 3, 4, 9},
                        {4, 9, 3, 6, 2, 1, 5, 7, 8},
                        {8, 5, 7, 9, 4, 3, 2, 6, 1},
                        {2, 6, 1, 7, 5, 8, 9, 3, 4},
                        {9, 3, 4, 1, 6, 2, 7, 8, 5},
                        {5, 7, 8, 3, 9, 4, 6, 1, 2},
                        {1, 2, 6, 5, 8, 7, 4, 9, 3},
                        {3, 4, 9, 2, 1, 6, 8, 5, 7}
                };

        var input = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < inputValues.length; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < inputValues[i].length; j++) {
                row.add(inputValues[i][j]);
            }
            input.add(row);
        }

        var expected = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < expectedValues.length; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < expectedValues[i].length; j++) {
                row.add(expectedValues[i][j]);
            }
            expected.add(row);
        }

        var actual = new SolveSudoku().solveSudoku(input);
        assertTrue(expected.equals(actual));
    }
}