package com.algorithms.datastructures.recursion.staircaseTraversal;

public class StaircaseTraversalSolution3 {
    public int staircaseTraversal(int height, int maxSteps) {
        int[] numOfWays = new int[height + 1];
        numOfWays[0] = 1;
        numOfWays[1] = 1;

        for (int currentHeight = 2; currentHeight < height + 1; currentHeight++) {
            int step = 1;
            while (step <= maxSteps && step <= currentHeight) {
                numOfWays[currentHeight] = numOfWays[currentHeight] + numOfWays[currentHeight - step];
                step+=1;
            }
        }

        return numOfWays[height];
    }
}
