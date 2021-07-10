package com.algorithms.datastructures.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LevenshteinDistanceTest {

    @Test
    public void levenshteinDistance_returnMinimumDistance() {
        assertEquals(2, LevenshteinDistance.levenshteinDistance("abc", "yabd"));
        assertEquals(3, LevenshteinDistance.levenshteinDistance("", "abc"));
    }
}
