package com.algorithms.datastructures.stacks;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Source: https://www.algoexpert.io/questions/Sunset%20Views
 */
public class SunsetViewsSolution2 {
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        int currentIdx = 0;
        int step = 1;

        if ("WEST".equals(direction)) {
            currentIdx = buildings.length - 1;
            step = -1;
        }

        ArrayList<Integer> candidateBuildings = new ArrayList<>();
        while (currentIdx >= 0 && currentIdx < buildings.length) {
            int buildingHeight = buildings[currentIdx];
            while (candidateBuildings.size() > 0 && buildingHeight >= buildings[candidateBuildings.get(candidateBuildings.size() - 1)]) {
                candidateBuildings.remove(candidateBuildings.size() - 1);
            }

            candidateBuildings.add(currentIdx);

            currentIdx += step;
        }

        if ("WEST".equals(direction)) {
            Collections.reverse(candidateBuildings);
        }

        return candidateBuildings;
    }
}
