package com.algorithms.datastructures.dynamicProgramming.numberOfWaysToTraverseGraph;

public class NumberOfWaysToTraverseGraphSolution3 {
    public int numberOfWaysToTraverseGraph(int width, int height) {
        int widthSubtracted = width - 1;
        int heightSubtracted = height - 1;

        int numerator = factorial(widthSubtracted + heightSubtracted);
        int denominator = factorial(widthSubtracted) * factorial(heightSubtracted);
        return numerator / denominator;
    }

    private int factorial(int num) {
        int result = 1;

        for (int i = 2; i <= num; i++) {
            result *= i;
        }

        return result;
    }
}
