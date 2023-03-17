package com.algorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NextGreaterElementAlgoLabTest {

    @Test
    public void testNextLargerElement() {
        // Arrange
        NextGreaterElementAlgoLab nle = new NextGreaterElementAlgoLab();
        int[] input = {4, 5, 2, 25};

        // Act
        int[] output = nle.nextLargerElement(input);

        // Assert
        assertArrayEquals(new int[]{5, 25, 25, -1}, output);
    }
}
