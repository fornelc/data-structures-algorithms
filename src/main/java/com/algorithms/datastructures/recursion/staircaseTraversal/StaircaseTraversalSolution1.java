package com.algorithms.datastructures.recursion.staircaseTraversal;

/**
 * Source: https://www.algoexpert.io/questions/Staircase%20Traversal
 *
 * Explained in Bitbucket
 *
 */
public class StaircaseTraversalSolution1 {
    public int staircaseTraversal(int height, int maxSteps) {
        return helper(height, maxSteps);
    }

    private int helper(int height, int maxSteps) {
        if (height <= 1) {
            return 1;
        }

        int numOfWays = 0;

        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
            numOfWays += helper(height - step, maxSteps);
        }

        return numOfWays;
    }
}
