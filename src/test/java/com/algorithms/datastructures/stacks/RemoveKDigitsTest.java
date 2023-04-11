package com.algorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveKDigitsTest {

    @Test
    public void testRemoveKDigits() {
        final String num = "1432219";
        final int k = 3;
        final String expectedOutput = "1219";

        final String output = new RemoveKDigits().removeKdigits(num, k);

        assertEquals(expectedOutput, output);
    }
}
