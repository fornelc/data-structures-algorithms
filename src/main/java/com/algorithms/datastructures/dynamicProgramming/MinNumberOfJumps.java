package com.algorithms.datastructures.dynamicProgramming;

import java.util.Arrays;

public class MinNumberOfJumps {
    public static int minNumberOfJumps(int[] array) {
        int[] minNumberJumps = new int[array.length];
        Arrays.fill(minNumberJumps, Integer.MAX_VALUE);
        minNumberJumps[0] = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i <= j + array[j]) {
                    minNumberJumps[i] = Math.min(minNumberJumps[i],
                                                minNumberJumps[j] + 1);
                }
            }
        }
        return minNumberJumps[array.length - 1];
    }
}
