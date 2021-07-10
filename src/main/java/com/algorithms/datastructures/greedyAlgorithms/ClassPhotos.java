package com.algorithms.datastructures.greedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Source: https://www.algoexpert.io/questions/Class%20Photos
 */
public class ClassPhotos {
    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights, Collections.reverseOrder());
        Collections.sort(blueShirtHeights, Collections.reverseOrder());

        final String firstRowShirt = redShirtHeights.get(0) > blueShirtHeights.get(0) ? "BLUE" : "RED";

        for (int i = 0; i < redShirtHeights.size(); i++) {
            int redShirtHeight = redShirtHeights.get(i);
            int blueShirtHeight = blueShirtHeights.get(i);

            if (firstRowShirt.equals("RED")) {
                if (redShirtHeight >= blueShirtHeight) {
                    return false;
                }
            } else {
                if (blueShirtHeight >= redShirtHeight) {
                    return false;
                }
            }
        }

        return true;
    }
}
