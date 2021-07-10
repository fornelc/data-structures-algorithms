package com.algorithms.datastructures.greedyAlgorithms;

public class ValidStartingCitySolution1 {
    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int citiesLength = distances.length;

        for (int startCityIdx = 0; startCityIdx < citiesLength; startCityIdx++) {
            int milesRemaining = 0;
            for (int currentCityIdx = startCityIdx; currentCityIdx < startCityIdx + citiesLength; currentCityIdx++) {
                if (milesRemaining < 0) {
                    break;
                }

                int rotatedIdx = currentCityIdx % citiesLength;
                int distance = distances[rotatedIdx];
                int currentFuel = fuel[rotatedIdx];
                milesRemaining += (currentFuel * mpg) - distance;
            }
            if (milesRemaining >= 0) {
                return startCityIdx;
            }
        }
        return -1;
    }
}
