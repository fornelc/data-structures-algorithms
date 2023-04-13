package com.algorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestRectangleTest {

    @Test
    public void testLargestRectangle() {
        int[] heights = new int[]{2,1,5,6,2,3};
        int expectedResult = 10;

        int result = new LargestRectangle().largestRectangleArea(heights);

        assertEquals(expectedResult, result);
    }
}
