package com.algorithms.datastructures.stacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NextGreaterElementSolution1Test {
    @Test
    public void TestCase1() {
        int[] input = new int[] {2, 5, -3, -4, 6, 7, 2};
        int[] expected = new int[] {5, 6, 6, 6, 7, -1, 5};
        int[] actual = new NextGreaterElementSolution1().nextGreaterElement(input);
        Assertions.assertArrayEquals(expected, actual);
    }
}
