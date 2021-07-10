package com.algorithms.datastructures.arrays;

import java.util.*;

public class LargestRange {
    public static int[] largestRange(int[] array) {
        int[] bestRange = new int[2];
        int longestLength = 0;
        Map<Integer, Boolean> numbersExplored = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            numbersExplored.put(array[i], false);
        }

        for (int num : array) {
            if (numbersExplored.get(num)) {
                continue;
            }

            numbersExplored.put(num, true);
            int leftCurrentRange =  num - 1;
            int rightCurrentRange = num + 1;
            int currentLengthRange = 1;

            while (numbersExplored.containsKey(leftCurrentRange)) {
                numbersExplored.put(leftCurrentRange, true);
                currentLengthRange++;
                leftCurrentRange--;
            }

            while (numbersExplored.containsKey(rightCurrentRange)) {
                numbersExplored.put(rightCurrentRange, true);
                currentLengthRange++;
                rightCurrentRange++;
            }

            if (longestLength < currentLengthRange) {
                longestLength = currentLengthRange;
                bestRange[0] = leftCurrentRange + 1;
                bestRange[1] = rightCurrentRange - 1;
            }
        }

        return bestRange;
    }
}
