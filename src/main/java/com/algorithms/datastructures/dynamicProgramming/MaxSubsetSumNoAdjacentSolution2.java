package com.algorithms.datastructures.dynamicProgramming;

// Time O(n) | Space O(1)
public class MaxSubsetSumNoAdjacentSolution2 {
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

        int first = Math.max(array[0], array[1]);
        int second = array[0];
        for (int i = 2; i < array.length; i ++) {
            int current = Math.max(first, second + array[i]);
            second = first;
            first = current;
        }
        return first;
    }
}
