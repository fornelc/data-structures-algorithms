package com.algorithms.datastructures.topKElement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class KClosestTest {

    @Test
    public void testKClosest() {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        int[][] expectedOutput = {{-2, 2}};

        assertArrayEquals(expectedOutput, new KClosest().kClosest(points, k));
    }
}
