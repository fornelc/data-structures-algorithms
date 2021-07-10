package com.algorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: https://www.algoexpert.io/questions/Remove%20Islands
 *
 * How to Solve:
 *
 * Solve this problem knowing the positions of all the non-island 1s.
 *
 * Find and store the positions of all the non-island 1s.
 * You can do this by performing a graph traversal (depth-first search, for example) on all the 1s
 * that are on the border of the image.
 * Afterwards, you can easily identify and remove all the island 1s from the input matrix
 * by relying on the data structure that you used to store the positions of non-island 1s.
 *
 * Space & time complexity:
 *
 * O(wh) time | O(wh) space - where w and h are the width and height of the input matrix
 *
 * Deep explanation of the time complexity in Solution 2.
 *
 * It has O(wh) space because we have to create an auxiliary data structure
 * that is the exact same size as our input matrix, this data structure will be filled with true or false,
 * instead of zeros and ones.
 */
public class RemoveIslands {
    public int[][] removeIslands(int[][] matrix) {
        boolean[][] onesConnectedToBorder = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                boolean rowBorder = row == 0 || row == matrix.length - 1;
                boolean colBorder = col == 0 || col == matrix[0].length - 1;
                boolean isBorder = rowBorder || colBorder;

                if (!isBorder) {
                    continue;
                }

                if (matrix[row][col] != 1) {
                    continue;
                }

                findOnesConnectedToBorder(row, col, matrix, onesConnectedToBorder);
            }
        }

        for (int row = 1; row < matrix.length - 1; row ++) {
            for (int col = 1; col < matrix[0].length - 1; col++) {
                if (!onesConnectedToBorder[row][col]) {
                    matrix[row][col] = 0;
                }
            }
        }

        return matrix;
    }

    private void findOnesConnectedToBorder(int row, int col, int[][] matrix, boolean[][] visited) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        while (!stack.isEmpty()) {
            int[] stackPop = stack.pop();
            int currentRow = stackPop[0];
            int currentCol = stackPop[1];

            // We continue if already visited, to avoid visiting again the same element in the matrix,
            // and provoking an infinite while loop.
            if (visited[currentRow][currentCol]) {
                continue;
            }

            visited[currentRow][currentCol] = true;

            List<int[]> neighbors = getNeighbors(currentRow, currentCol, matrix);
            for (int[] neighbor : neighbors) {
                int neighborRow = neighbor[0];
                int neighborCol = neighbor[1];
                if (matrix[neighborRow][neighborCol] != 1) {
                    continue;
                }
                stack.push(new int[]{neighborRow, neighborCol});
            }
        }
    }

    private List<int[]> getNeighbors(int row, int col, int[][] matrix) {
        List<int[]> neighbors = new ArrayList<>();
        if (row - 1 >= 0) {
            neighbors.add(new int[]{row-1, col});
        }
        if (row + 1 < matrix.length) {
            neighbors.add(new int[]{row + 1, col});
        }
        if (col - 1 >= 0) {
            neighbors.add(new int[]{row, col - 1});
        }
        if (col + 1 < matrix[0].length) {
            neighbors.add(new int[]{row, col + 1});
        }
        return neighbors;
    }
}
