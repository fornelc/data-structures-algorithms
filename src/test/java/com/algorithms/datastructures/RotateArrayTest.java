package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateArrayTest {
    private RotateArray sut;

    @BeforeEach
    public void setUp() {
        sut = new RotateArray();
    }

    @Test
    public void rotate() {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        sut.rotate(nums, 9);
        assertArrayEquals(nums, new int[]{5,6,7,1,2,3,4});
    }
}
