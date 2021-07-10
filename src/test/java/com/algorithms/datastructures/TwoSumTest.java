package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumTest {
    private TwoSum sut;

    @BeforeEach
    public void setUp() {
        sut = new TwoSum();
    }

    @Test
    public void twoSum() {
        int[] result = sut.twoSum(new int[] {2,7,11,15}, 9);
        assertArrayEquals(result, new int[] {0,1});
        result = sut.twoSum(new int[] {3,2,3}, 6);
        assertArrayEquals(result, new int[] {0,2});
    }

    @Test
    public void twoSumtwoSumApproach3() {
        int[] result = sut.twoSumApproach3(new int[] {2,7,11,15}, 9);
        assertArrayEquals(result, new int[] {0,1});
        result = sut.twoSumApproach3(new int[] {3,2,3}, 6);
        assertArrayEquals(result, new int[] {0,2});
    }
}
