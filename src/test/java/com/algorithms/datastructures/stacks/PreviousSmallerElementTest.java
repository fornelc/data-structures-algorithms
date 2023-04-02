package com.algorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PreviousSmallerElementTest {

    @Test
    public void testCase() {
        int[] input = new int[]{4, 5, 2, 25};
        int[] expectedOutput = new int[]{-1, 4, -1, 2};

        int[] output = new PreviousSmallerElement().previousSmallerElement(input);

        assertArrayEquals(expectedOutput, output);
    }
}
