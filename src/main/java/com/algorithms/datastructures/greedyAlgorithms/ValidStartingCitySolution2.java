package com.algorithms.datastructures.greedyAlgorithms;

public class ValidStartingCitySolution2 {
    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int numberOfCities = distances.length;

        int milesLeft = 0;
        int indexOfStartingCityCandidate = 0;
        int milesRemainingAtStartingCityCandidate = 0;

        for (int currentCity = 1; currentCity < numberOfCities; currentCity++){
            int distanceFromPreviousCity = distances[currentCity - 1];
            int fuelFromPreviousCity = fuel[currentCity - 1];
            milesLeft += fuelFromPreviousCity * mpg - distanceFromPreviousCity;

            if (milesLeft < milesRemainingAtStartingCityCandidate) {
                indexOfStartingCityCandidate = currentCity;
                milesRemainingAtStartingCityCandidate = milesLeft;
            }
        }

        return indexOfStartingCityCandidate;
    }
}
