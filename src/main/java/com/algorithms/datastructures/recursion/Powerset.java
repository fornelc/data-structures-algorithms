package com.algorithms.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Source: https://www.algoexpert.io/questions/Powerset
 *
 * How to solve and time and space complexity explained in rocket book.
 */
public class Powerset {
    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        subsets.add(new ArrayList<Integer>());
        for (Integer ele: array) {
            int length = subsets.size();
            for (int i = 0; i < length; i++) {
                List<Integer> currentSubset = new ArrayList<Integer>(subsets.get(i));
                currentSubset.add(ele);
                subsets.add(currentSubset);
            }
        }
        return subsets;
    }
}
