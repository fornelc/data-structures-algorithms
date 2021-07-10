package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindThreeLargestNumbersTest {
    private FindThreeLargestNumbers sut;

    @BeforeEach
    public void setUp() {
        sut = new FindThreeLargestNumbers();
    }

    @Test
    public void findThreeLargestNumbers_returnThreeLargestNumbers() {
        int[] input = new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        int[] result = sut.findThreeLargestNumbers(input);
        assertEquals(18, result[0]);
        assertEquals(141, result[1]);
        assertEquals(541, result[2]);
    }
}
