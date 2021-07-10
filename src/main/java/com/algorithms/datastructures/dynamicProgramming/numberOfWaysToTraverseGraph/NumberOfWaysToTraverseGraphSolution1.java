package com.algorithms.datastructures.dynamicProgramming.numberOfWaysToTraverseGraph;

public class NumberOfWaysToTraverseGraphSolution1 {
    public int numberOfWaysToTraverseGraph(int width, int height) {
        if (width == 1 || height == 1) {
            return 1;
        }

        return numberOfWaysToTraverseGraph(width - 1, height)
                + numberOfWaysToTraverseGraph(width, height - 1);
    }
}
