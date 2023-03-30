package com.algorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreviousGreaterElementTest {

    @Test
    public void testCase() {
        int[] input = new int[]{ 13, 7, 6, 12};
        int[] expected = new int[]{-1, -1, 5, -1};

        int[] output = new PreviousGreaterElement().previousLargerElement(input);

        assertEquals(expected, output);
    }

}
