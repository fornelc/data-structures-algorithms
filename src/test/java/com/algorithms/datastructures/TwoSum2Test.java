package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSum2Test {
    private TwoSum2 sut;

    @BeforeEach
    public void setUp() {
        sut = new TwoSum2();
    }

    @Test
    public void twoSum() {
        int[] result = sut.twoSum(new int[] {2,7,11,15}, 9);
        assertArrayEquals(result, new int[] {1,2});
        result = sut.twoSum(new int[] {2,3,4}, 6);
        assertArrayEquals(result, new int[] {1,3});
        result = sut.twoSum(new int[] {-1,0}, -1);
        assertArrayEquals(result, new int[] {1,2});
    }

    @Test
    public void twoSumApproach1() {
        int[] result = sut.twoSumApproach1(new int[] {2,7,11,15}, 9);
        assertArrayEquals(result, new int[] {1,2});
        result = sut.twoSumApproach1(new int[] {2,3,4}, 6);
        assertArrayEquals(result, new int[] {1,3});
        result = sut.twoSumApproach1(new int[] {-1,0}, -1);
        assertArrayEquals(result, new int[] {1,2});
    }
}
