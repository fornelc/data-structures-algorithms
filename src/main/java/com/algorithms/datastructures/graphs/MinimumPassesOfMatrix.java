package com.algorithms.datastructures.graphs;

import java.util.*;

/**
 * Write a function that takes in an integer matrix of potentially unequal height
 * and width and returns the minimum number of passes required to convert all
 * negative integers in the matrix to positive integers.
 *
 * In this solution we will use two queues to store the positions of the positive elements.
 *
 * Tutorial explaining Queue works in Java: http://tutorials.jenkov.com/java-collections/queue.html
 *
 * O(w * h) time | O(w * h) space - where w is the width of the matrix and h is the height
 */
public class MinimumPassesOfMatrix {
    public int minimumPassesOfMatrix(int[][] matrix) {
        int passes = getNumberOfPasses(matrix);
        return !matrixContainsNegatives(matrix) ? passes - 1 : -1;
    }

    private int getNumberOfPasses(int[][] matrix) {
        int passes = 0;
        Queue<int[]> nextQueue = getPositiveNumbers(matrix);

        while (!nextQueue.isEmpty()) {
            Queue<int[]> currentQueue = nextQueue;
            nextQueue = new LinkedList<>();

            while(!currentQueue.isEmpty()) {
                int[] currentPosition = currentQueue.remove();

                List<int[]> adjacentPositions = getAdjacentPositions(currentPosition, matrix);

                for (int[] position : adjacentPositions) {
                    int row = position[0];
                    int col = position[1];
                    if (matrix[row][col] < 0) {
                        matrix[row][col] *= -1;
                        nextQueue.add(new int[] {row, col});
                    }
                }
            }
            passes++;
        }

        return passes;
    }

    private Queue<int[]> getPositiveNumbers(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int b = 0; b < matrix[0].length; b++) {
                if (matrix[i][b] > 0) {
                    queue.add(new int[]{i,b});
                }
            }
        }
        return queue;
    }

    private List<int[]> getAdjacentPositions(int[] position, int[][] matrix) {
        List<int[]> adjacentPositions = new ArrayList<>();
        int row = position[0];
        int col = position[1];
        if (row > 0) {
            adjacentPositions.add(new int[] {row - 1, col});
        }
        if (col > 0) {
            adjacentPositions.add(new int[] {row, col - 1});
        }
        if (row < matrix.length - 1) {
            adjacentPositions.add(new int[] {row + 1, col});
        }
        if (col < matrix[0].length - 1) {
            adjacentPositions.add(new int[] {row, col + 1});
        }
        return adjacentPositions;
    }

    private boolean matrixContainsNegatives(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                if (value < 0) {
                    return true;
                }
            }
        }
        return false;
    }
}