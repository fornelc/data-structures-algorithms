package com.algorithms.datastructures.dynamicProgramming;

public class MaximizeExpressionSolution1 {
    public int maximizeExpression(int[] array) {
        if (array.length < 4) {
            return 0;
        }

        int maxValue = Integer.MIN_VALUE;

        for (int a = 0; a < array.length; a++) {
            int aValue = array[a];
            for (int b = a + 1; b < array.length; b++) {
                int bValue = array[b];
                for (int c = b + 1; c < array.length; c++) {
                    int cValue = array[c];
                    for (int d = c + 1; d < array.length; d++) {
                        int dValue = array[d];
                        int currentValue = retrieveOperationValue(aValue, bValue, cValue, dValue);
                        maxValue = Math.max(currentValue, maxValue);
                    }
                }
            }
        }
        return maxValue;
    }

    private int retrieveOperationValue(int aValue, int bValue, int cValue, int dValue) {
        return aValue - bValue + cValue - dValue;
    }
}
