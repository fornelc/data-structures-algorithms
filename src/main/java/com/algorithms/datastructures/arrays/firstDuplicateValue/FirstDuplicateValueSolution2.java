package com.algorithms.datastructures.arrays.firstDuplicateValue;

import java.util.HashSet;

public class FirstDuplicateValueSolution2 {
    public int firstDuplicateValue(int[] array) {
        HashSet set = new HashSet();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                return array[i];
            }
            set.add(array[i]);
        }

        return -1;
    }
}
