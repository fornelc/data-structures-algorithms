package com.algorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NextGreaterElement3Test {

    @Test
    public void testCase() {
        int[] input = new int[]{1, 2, 3, 4, 3};
        int[] expectedOutput = new int[]{2, 3, 4, -1, 4};

        int[] output = new NextGreaterElement3().nextGreaterElements(input);

        assertArrayEquals(expectedOutput, output);
    }

    @Test
    public void testCase2() {
        int[] input = new int[]{6, 2, 3, 4, 5};
        int[] expectedOutput = new int[]{-1, 3, 4, 5, 6};

        int[] output = new NextGreaterElement3().nextGreaterElements(input);

        assertArrayEquals(expectedOutput, output);
    }
}
