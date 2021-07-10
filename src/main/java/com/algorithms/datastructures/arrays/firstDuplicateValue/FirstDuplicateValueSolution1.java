package com.algorithms.datastructures.arrays.firstDuplicateValue;

public class FirstDuplicateValueSolution1 {
    public int firstDuplicateValue(int[] array) {
        int minimumIndexDuplicate = array.length;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    minimumIndexDuplicate = Math.min(minimumIndexDuplicate, j);
                }
            }
        }

        return minimumIndexDuplicate == array.length ? -1 : array[minimumIndexDuplicate];
    }
}
