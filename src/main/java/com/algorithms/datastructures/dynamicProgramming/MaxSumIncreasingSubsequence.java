package com.algorithms.datastructures.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumIncreasingSubsequence {
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        int[] sequences = new int[array.length];
        Arrays.fill(sequences, Integer.MIN_VALUE);
        int[] sums = array.clone();
        int maxSumIndex = 0;
        for (int i = 0; i < array.length; i++) {
            int currentValue = array[i];
            for (int j = 0; j < i; j++) {
                int previousNumber = array[j];
                if (previousNumber < currentValue && sums[j] + currentValue >= sums[i]) {
                    sums[i] = array[j] + sums[i];
                    sequences[i] = j;
                }
            }
            if (sums[i] > sums[maxSumIndex]) {
                maxSumIndex = i;
            }
        }

        return retrieveSubsequence(sequences, array, maxSumIndex, sums);
    }

    private static List<List<Integer>> retrieveSubsequence(int[] sequences, int[] array,
                                                           int currentIdx, int[] sums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(sums[currentIdx]));
        List<Integer> resultSequence = new ArrayList<>();
        while (currentIdx != Integer.MIN_VALUE) {
            resultSequence.add(0, array[currentIdx]);
            currentIdx = sequences[currentIdx];
        }
        result.add(resultSequence);
        return result;
    }
}
