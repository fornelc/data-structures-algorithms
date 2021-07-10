package com.algorithms.datastructures.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LevenshteinDistanceSolution2Test {
    @Test
    public void levenshteinDistance_returnMinimumDistance() {
        assertEquals(2, LevenshteinDistanceSolution2.levenshteinDistance("abc", "yabd"));
//        assertEquals(3, LevenshteinDistanceSolution2.levenshteinDistance("", "abc"));
    }
}
