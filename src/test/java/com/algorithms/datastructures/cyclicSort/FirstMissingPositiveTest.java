package com.algorithms.datastructures.cyclicSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstMissingPositiveTest {

    @Test
    public void testFirstMissingPositive() {
        FirstMissingPositive fmp = new FirstMissingPositive();

        int[] nums1 = {1, 2, 0};
        int expected1 = 3;
        assertEquals(expected1, fmp.firstMissingPositive(nums1));

        int[] nums2 = {3, 4, -1, 1};
        int expected2 = 2;
        assertEquals(expected2, fmp.firstMissingPositive(nums2));

        int[] nums3 = {7, 8, 9};
        int expected3 = 1;
        assertEquals(expected3, fmp.firstMissingPositive(nums3));
    }
}
