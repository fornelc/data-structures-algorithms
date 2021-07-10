package com.algorithms.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveCoveredIntervalsTest {
    @Test
    public void removeCoveredIntervalsTest_returnsNumberOfRemainingIntervals() {
        RemoveCoveredIntervals removeCoveredIntervals = new RemoveCoveredIntervals();
        assertEquals(removeCoveredIntervals.removeCoveredIntervals(buildIntervals()), 1);
    }

    private int[][] buildIntervals() {
        return new int[][]{{1,2},{1,4},{3,4}};
    }
}
