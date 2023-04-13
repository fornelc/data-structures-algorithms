package com.algorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximalRectangleTest {

    @Test
    public void testMaximalRectangle() {
        char[][] matrix = new char[][]{{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        int expectedOutput = 6;

        int output = new MaximalRectangle().maximalRectangle(matrix);

        assertEquals(expectedOutput, output);
    }
}
