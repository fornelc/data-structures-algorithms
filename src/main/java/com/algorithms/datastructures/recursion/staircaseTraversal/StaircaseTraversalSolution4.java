package com.algorithms.datastructures.recursion.staircaseTraversal;

import java.util.ArrayList;
import java.util.List;

public class StaircaseTraversalSolution4 {
    public int staircaseTraversal(int height, int maxSteps) {
        List<Integer> numOfWays = new ArrayList<>();
        numOfWays.add(1);

        int currentNumWays = 0;
        for (int currentHeight = 1; currentHeight < height + 1; currentHeight++) {
            int startWindow = currentHeight - maxSteps - 1;
            int endWindow = currentHeight - 1;

            if (startWindow >= 0) {
                currentNumWays = currentNumWays - numOfWays.get(startWindow);
            }

            currentNumWays = currentNumWays + numOfWays.get(endWindow);
            numOfWays.add(currentNumWays);
        }

        return numOfWays.get(height);
    }
}
