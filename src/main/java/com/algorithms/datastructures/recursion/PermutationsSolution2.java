package com.algorithms.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Source: https://www.algoexpert.io/questions/Permutations
 *
 * How to solve and Time and Space complexity:
 *
 * Explained in rocket book
 */
public class PermutationsSolution2 {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        getPermutations(0, array, permutations);
        return permutations;
    }

    private static void getPermutations(int i, List<Integer> array, List<List<Integer>> permutations) {
        if (i == array.size() - 1) {
            permutations.add(new ArrayList<Integer>(array)); // we add a copy of the array in permutations,
                                                             // without doing this the arrays in the permutations list,
                                                             // will be modified when swapping the elements in the array.
        } else {
            for (int j = i; j < array.size(); j++) {
                swap(array, i, j);
                getPermutations(i + 1, array, permutations);
                swap(array, i, j);
            }
        }
    }

    private static void swap(List<Integer> array, int i, int j) {
        Integer tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }
}
