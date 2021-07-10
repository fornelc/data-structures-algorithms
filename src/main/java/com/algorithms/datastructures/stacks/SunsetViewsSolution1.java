package com.algorithms.datastructures.stacks;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Source: https://www.algoexpert.io/questions/Sunset%20Views
 */
public class SunsetViewsSolution1 {
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        int maxHeight = 0;

        int currentBuilding = 0;
        int step = 1;

        if ("EAST".equals(direction)) {
            currentBuilding = buildings.length - 1;
            step = -1;
        }

        ArrayList<Integer> output = new ArrayList<>();
        while (currentBuilding >=0 && currentBuilding < buildings.length) {
            if (buildings[currentBuilding] > maxHeight) {
                maxHeight = buildings[currentBuilding];
                output.add(currentBuilding);
            }
            currentBuilding += step;
        }

        if ("EAST".equals(direction)) {
            Collections.reverse(output);
        }

        return output;
    }
}
