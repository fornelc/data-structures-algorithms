package com.algorithms.datastructures.arrays.sortedSquaredArray;

import java.util.Arrays;

public class SortedSquaredArraySolution1 {
    public int[] sortedSquaredArray(int[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = array[i] * array[i];
        }

        Arrays.sort(result);

        return result;
    }
}
