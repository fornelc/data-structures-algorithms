package com.algorithms.datastructures.arrays;

public class SubarraySort {
    public static int[] subarraySort(int[] array) {
        int minUnsortedValue = Integer.MAX_VALUE;
        int maxUnsortedValue = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if(unsortedValue(i, array)) {
                minUnsortedValue = Math.min(minUnsortedValue, array[i]);
                maxUnsortedValue = Math.max(maxUnsortedValue, array[i]);
            }
        }

        if (minUnsortedValue == Integer.MAX_VALUE) {
            return new int[] {-1, -1};
        }

        int subArrayLeftIdx = 0;
        while (array[subArrayLeftIdx] <= minUnsortedValue) {
            subArrayLeftIdx++;
        }

        int subArrayRightIdx = array.length - 1;
        while (array[subArrayRightIdx] >= maxUnsortedValue) {
            subArrayRightIdx--;
        }

        return new int[] {subArrayLeftIdx, subArrayRightIdx};
    }

    private static boolean unsortedValue(int i, int[] array) {
        if (i == 0) {
            return array[i] > array[i+1];
        } else if (i == array.length - 1) {
            return array[i] < array[i-1];
        }

        return array[i] < array[i-1] || array[i] > array[i+1];
    }
}
