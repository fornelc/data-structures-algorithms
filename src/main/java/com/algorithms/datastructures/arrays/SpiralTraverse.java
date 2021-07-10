package com.algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    /**
     * https://www.algoexpert.io/questions/Spiral%20Traverse
     * Write a function that takes in an n x m two-dimensional array (that can be
     * square-shaped when n == m) and returns a one-dimensional array of all the
     * array's elements in spiral order.
     *
     * How to solve:
     * - You can think of the spiral that you have to traverse as a set of rectangle perimeters
     * that progressively get smaller (i.e., that progressively move inwards in the two-dimensional array).
     *
     * Declare four variables: a starting row, a starting column, an ending row, and an ending column.
     * These four variables represent the bounds of the first rectangle perimeter in the spiral that you have to traverse.
     * Traverse that perimeter using those bounds, and then move the bounds inwards.
     * End your algorithm once the starting row passes the ending row or the starting column passes the ending column.
     *
     * You can solve this problem both iteratively and recursively following very similar logic.
     *
     * O(n) time | O(n) space - where n is the total number of elements in the two dimensional array.
     * In the iterative solution, it is O(n) time because we are just traversing through every single value once,
     * and O(n) space comes from the fact that we store n values in our result array.
     * And we don't use extra space except for the four variables created.
     * Time and Space complexity is the same for both, for the iterative and the recursive solutions.
     * If we would put the array solution aside, in the iterative solution we would have constant space time,
     * and in the recursive solution we won't have constant space because we're gonna have a bunch of recursive
     * calls on the call stack, we would have a recursive call for each perimeter in the square,
     * probably is gonna be fewer than half of the width or of the height of the array. So it would be very small.
     * But it would not be constant space.
     * So then it gets eliminated or rather captured by the result array which is O(n) space.
     * Because there are n values in the result array.
     */
    public static List<Integer> spiralTraverse(int[][] array) {
        int startRow = 0;
        int endRow = array.length - 1;
        int startCol = 0;
        int endCol = array[0].length - 1;
        List<Integer> result = new ArrayList<>();
        while (startRow <= endRow && startCol <= endCol) {
            // Add first row
            for (int i = startCol; i <= endCol; i++) {
                result.add(array[startRow][i]);
            }

            // Add last column
            for (int i = startRow + 1; i <= endRow; i++) {
                result.add(array[i][endCol]);
            }

            // Add last row
            for (int i = endCol - 1; i >= startCol; i--) {
                // Handle the edge case when there's a single row
                // in the middle of the matrix. In this case, we don't
                // want to double-count the values in this row, which
                // we've already counted in the first for loop above.
                // See Test Case 8 for an example of this edge case.
                if (startRow == endRow) {
                    break;
                }
                result.add(array[endRow][i]);
            }
            // Add first column
            for (int i = endRow - 1; i > startRow; i--) {
                // Handle the edge case when there's a single column
                // in the middle of the matrix. In this case, we don't
                // want to double-count the values in this column, which
                // we've already counted in the second for loop above.
                // See Test Case 9 for an example of this edge case.
                if (startCol == endCol) {
                    break;
                }
                result.add(array[i][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return result;
    }

    public static List<Integer> spiralTraverseRecursive(int[][] array) {
        List<Integer> result = new ArrayList<>();
        spiralHelper(array, 0, array.length - 1, 0, array[0].length - 1, result);
        return result;
    }

    private static void spiralHelper(int[][] array, int startRow, int endRow, int startCol, int endCol, List<Integer> result) {
        if (startRow > endRow || startCol > endCol) {
            return;
        }
        // Add first row
        for (int col = startCol; col <= endCol; col++) {
            result.add(array[startRow][col]);
        }

        // Add last column
        for (int row = startRow + 1; row <= endRow; row++) {
            result.add(array[row][endCol]);
        }

        // Add last row
        for (int col = endCol - 1; col >= startCol; col--) {
            // Handle the edge case when there's a single row
            // in the middle of the matrix. In this case, we don't
            // want to double-count the values in this row, which
            // we've already counted in the first for loop above.
            // See Test Case 8 for an example of this edge case.
            if (startRow == endRow) {
                break;
            }
            result.add(array[endRow][col]);
        }
        // Add first column
        for (int row = endRow - 1; row > startRow; row--) {
            // Handle the edge case when there's a single column
            // in the middle of the matrix. In this case, we don't
            // want to double-count the values in this column, which
            // we've already counted in the second for loop above.
            // See Test Case 9 for an example of this edge case.
            if (startCol == endCol) {
                break;
            }
            result.add(array[row][startCol]);
        }

        spiralHelper(array, startRow + 1, endRow - 1, startCol + 1, endCol - 1, result);
    }

}
