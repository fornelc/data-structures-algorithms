package com.algorithms.datastructures.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class KnapsackProblem {
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int[][] knapsackValues = new int[items.length + 1][capacity + 1];
        for (int i = 1; i < knapsackValues.length; i++) {
            int currentValue = items[i - 1][0];
            int currentWeight = items[i - 1][1];
            for (int b = 1; b < knapsackValues[0].length; b++) {
                if(b >= currentWeight) {
                    knapsackValues[i][b] = Math.max(knapsackValues[i-1][b],
                                                    knapsackValues[i-1][b - currentWeight] + currentValue);
                } else {
                    knapsackValues[i][b] = knapsackValues[i-1][b];
                }
            }
        }
        return retrieveKnapsackItems(knapsackValues, items,
                knapsackValues[knapsackValues.length - 1][knapsackValues[0].length - 1]);
    }

    private static List<List<Integer>> retrieveKnapsackItems(int[][] knapsackValues, int[][] items, int capacity) {
        List<List<Integer>> sequence = new ArrayList<>();
        List<Integer> totalWeight = new ArrayList<>();
        totalWeight.add(capacity);
        sequence.add(totalWeight);
        sequence.add(new ArrayList<>());
        int i = knapsackValues.length - 1;
        int b = knapsackValues[0].length - 1;
        while (i > 0) {
            if (knapsackValues[i][b] == knapsackValues[i - 1][b]) {
                i--;
            } else {
                sequence.get(1).add(0, i-1);
                b -= items[i-1][1];
                i--;
            }
        }
        return sequence;
    }
}
