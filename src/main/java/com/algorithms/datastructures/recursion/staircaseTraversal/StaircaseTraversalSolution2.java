package com.algorithms.datastructures.recursion.staircaseTraversal;

import java.util.*;

/**
 * Source: https://www.algoexpert.io/questions/Staircase%20Traversal
 *
 * Explained in Bitbucket
 *
 */
public class StaircaseTraversalSolution2 {
    public int staircaseTraversal(int height, int maxSteps) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 1);
        int result = helper(height, maxSteps, map);
        return result;
    }

    private int helper(int height, int maxSteps, Map<Integer, Integer> map) {
        if (map.containsKey(height)) {
            return map.get(height);
        }

        int numOfWays = 0;

        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
            numOfWays += helper(height - step, maxSteps, map);
        }

        map.put(height, numOfWays);

        return numOfWays;
    }
}
