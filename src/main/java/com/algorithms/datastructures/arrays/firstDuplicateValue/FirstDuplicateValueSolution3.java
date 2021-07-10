package com.algorithms.datastructures.arrays.firstDuplicateValue;

public class FirstDuplicateValueSolution3 {
    public int firstDuplicateValue(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int absValue = Math.abs(array[i]);
            if (array[absValue - 1] < 0) {
                return absValue;
            }
            array[absValue - 1] = array[absValue - 1] * -1;
        }

        return -1;
    }
}
