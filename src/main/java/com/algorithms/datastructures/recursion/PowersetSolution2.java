package com.algorithms.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Source: https://www.algoexpert.io/questions/Powerset
 *
 * How to solve and time and space complexity explained in rocket book.
 */
public class PowersetSolution2 {
    public static List<List<Integer>> powerset(List<Integer> array) {
        return powersetHelper(array, array.size() - 1);
    }

    private static List<List<Integer>> powersetHelper(List<Integer> array, int idx) {
        if (idx < 0) {
            List<List<Integer>> emptySubset = new ArrayList<>();
            emptySubset.add(new ArrayList<>());
            return emptySubset;
        }
        List<List<Integer>> subsets = powersetHelper(array, idx - 1);
        Integer elem = array.get(idx);
        int length = subsets.size();
        for (int i = 0; i < length; i++) {
            List<Integer> currentSubset = new ArrayList<>(subsets.get(i));
            currentSubset.add(elem);
            subsets.add(currentSubset);
        }
        return subsets;

    }
}
