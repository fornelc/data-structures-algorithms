package com.algorithms.datastructures.dynamicProgramming;

public class MaximumSumSubMatrix {
    public int maximumSumSubmatrix(int[][] matrix, int size) {
        int[][] sum = buildSumMatrix(matrix);

        int maxSum = Integer.MIN_VALUE;
        for (int row = size - 1; row < sum.length; row++) {
            for (int col = size - 1; col < sum[0].length; col++) {
                int total = sum[row][col];

                boolean touchTopBorder = row - size < 0;
                if (!touchTopBorder) {
                    total -= sum[row-size][col];
                }

                boolean touchLeftBorder = col - size < 0;
                if (!touchLeftBorder) {
                    total -= sum[row][col-size];
                }

                boolean touchLeftOrTopBorder = touchTopBorder || touchLeftBorder;
                if (!touchLeftOrTopBorder) {
                    total += sum[row-size][col-size];
                }

                maxSum = Math.max(maxSum, total);
            }
        }

        return maxSum;
    }

    private int[][] buildSumMatrix(int[][] matrix) {
        int[][] sum = new int[matrix.length][matrix[0].length];

        sum[0][0] = matrix[0][0];

        // Fill the first row
        for (int i = 1; i < matrix[0].length; i++) {
            sum[0][i] = sum[0][i-1] + matrix[0][i];
        }

        // Fill the first column
        for (int i = 1; i < matrix.length; i++) {
            sum[i][0] = sum[i-1][0] + matrix[i][0];
        }

        // Fill the rest of the matrix
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                sum[row][col] = sum[row-1][col] + sum[row][col-1] - sum[row-1][col-1] + matrix[row][col];
            }
        }

        return sum;
    }
}
