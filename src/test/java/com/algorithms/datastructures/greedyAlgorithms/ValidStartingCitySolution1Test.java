package com.algorithms.datastructures.greedyAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidStartingCitySolution1Test {
    @Test
    public void TestCase1() {
        int[] distances = new int[] {5, 25, 15, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int mpg = 10;
        int expected = 4;
        var actual = new ValidStartingCitySolution1().validStartingCity(distances, fuel, mpg);
        assertTrue(expected == actual);
    }
}
