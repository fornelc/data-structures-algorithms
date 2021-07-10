package com.algorithms.datastructures.arrays;

import java.util.*;

public class FourNumberSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Map<Integer, List<Integer[]>> sums = new HashMap<>();
        List<Integer[]> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int sum = array[j] + array[i];
                int difference = targetSum - sum;
                if (sums.containsKey(difference)) {
                    for (Integer[] pairs : sums.get(difference)) {
                        result.add(new Integer[] {pairs[0], pairs[1], array[i], array[j]});
                    }
                }
            }

            for (int j = i - 1; j >= 0; j--) {
                int sum = array[j] + array[i];
                if (sums.containsKey(sum)) {
                    sums.get(sum).add(new Integer[] {array[j], array[i]});
                } else {
                    List<Integer[]> newPair = new ArrayList<>();
                    newPair.add(new Integer[] {array[j], array[i]});
                    sums.put(sum, newPair);
                }
            }
        }

        return result;
    }
}
