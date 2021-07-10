package com.algorithms.datastructures.dynamicProgramming.numberOfWaysToTraverseGraph;

public class NumberOfWaysToTraverseGraphSolution2 {

    public int numberOfWaysToTraverseGraph(int width, int height) {
        int[][] numberOfWays = new int[height][width];

        for (int widthIdx = 0; widthIdx < width; widthIdx++) {
            for (int heightIdx = 0; heightIdx < height; heightIdx++) {
                if (widthIdx == 0 || heightIdx == 0) {
                    numberOfWays[heightIdx][widthIdx] = 1;
                } else {
                    int waysUp = numberOfWays[heightIdx][widthIdx - 1];
                    int waysLeft = numberOfWays[heightIdx - 1][widthIdx];
                    numberOfWays[heightIdx][widthIdx] = waysUp + waysLeft;
                }
            }
        }

        return numberOfWays[height - 1][width - 1];
    }
}
