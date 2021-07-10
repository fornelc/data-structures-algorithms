package com.algorithms.datastructures.dynamicProgramming;

/**
 * Time O(n) | Space O(n)
 */
public class MaxSubsetSumNoAdjacentSolution1 {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }
        int[] sumArray = new int[array.length];
        sumArray[0] = array[0];
        sumArray[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            sumArray[i] = Math.max(sumArray[i - 1], sumArray[i - 2] + array[i]);
        }

        return sumArray[sumArray.length - 1];
    }
}
