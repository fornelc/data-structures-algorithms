package com.algorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;

public class NextSmallerElementTest {

    @Test
    public void testCase() {
        int[] input = new int[]{4, 5, 2, 25};
        int[] expectedOutput = new int[]{2, 2, -1, -1};

        int[] output = new NextSmallerElement().nextSmallerElement(input);
    }

}
