package com.algorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: https://www.algoexpert.io/questions/Remove%20Islands
 *
 * How to solve:
 *
 * Part of the explanation is in Solution 1.
 *
 * You can also solve this problem without the use of a data structure that stores the positions of non-islands 1s.
 * Simply loop through the border of the image, and perform a depth-first search on all positions with the value 1.
 * During this depth-first search, find all the 1s that are connected to the original position on the border,
 * and change them from 1 to 2. After changing all non-island 1s to 2s, you can simply remove all the remaining 1s,
 * which are guaranteed to be islands, from the matrix (by replacing them with 0s),
 * and you can then change all the 2s back to 1s, since these were previously determined to be non-islands.
 *
 * Space & time complexity:
 *
 * O(wh) time | O(wh) space - where w and h are the width and height of the input matrix
 *
 * Explanation of why the time complexity is O(wh): We're looping through all of the positions in the matrix,
 * and whenever the position is equal to a border,
 * we're performing a depth first search on that position through a method.
 * The method that performs the depth first search (changeOnesConnectedToBorderToTwos()),
 * will never be equal to more than big O of w times h,
 * because we are never going to consider the same position multiple times.
 * So we have the two for loops that will run in O(wh)
 * and inside of the two for loops we have the depth first search method that runs in O(wh),
 * and that will give us O(2wh), and we can simply remove the 2
 * because when we talk about big O notation we remove the constants,
 * and that justifies to us why our time complexity is O(wh).
 *
 * The reason it runs in this space complexity, is because we need to perform a depth first search.
 * When we perform a depth first search, we use a Stack,
 * and this Stack could potentially have almost every single position in our two-dimensional matrix in it.
 * For example if the entire matrix was filled with just ones, that would mean that our stack, at some point in time,
 * would have almost every single position in our input matrix in it, which would be w times h positions.
 * But keep in mind, that this solution has much better average space complexity than the previous solution,
 * because probably our stack will never really have that many elements in it.
 * So our stack will be relatively small, but at most it could be w times h in size.
 *
 * So that's why this has a better average space complexity whereas the previous solution,
 * we always have a space complexity that is exactly equal to w times h
 * because we always create that auxiliary data structure, and we're always using that much space,
 * and we are also at the same time having the Stack that we need to use as well to perform the depth first search.
 * But when we look at the absolute maximum, so big O notation, we get the same of w times h.
 */
public class RemoveIslandsSolution2 {
    public int[][] removeIslands(int[][] matrix) {
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

                changeOnesConnectedToBorderToTwos(row, col, matrix);
            }
        }

        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] != 2) {
                    matrix[row][col] = 0;
                } else {
                    matrix[row][col] = 1;
                }
            }
        }

        return matrix;
    }

    private void changeOnesConnectedToBorderToTwos(int row, int col, int[][] matrix) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        while (!stack.isEmpty()) {
            int[] stackPop = stack.pop();
            int currentRow = stackPop[0];
            int currentCol = stackPop[1];

            // We continue if already visited, to avoid visiting again the same element in the matrix,
            // and provoking an infinite while loop.
            if (matrix[currentRow][currentCol] == 2) {
                continue;
            }

            matrix[currentRow][currentCol] = 2;

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
