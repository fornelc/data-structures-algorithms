package com.algorithms.datastructures.cyclicSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {

    @Test
    public void testMissingNumber() {
        MissingNumber solution = new MissingNumber();
        int[] nums1 = {3, 0, 1};
        int[] nums2 = {0, 1};
        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0 ,1};
        int[] nums4 = {0};

        int result1 = solution.missingNumber(nums1);
        int result2 = solution.missingNumber(nums2);
        int result3 = solution.missingNumber(nums3);
        int result4 = solution.missingNumber(nums4);

        assertEquals(2 ,result1);
        assertEquals(2 ,result2);
        assertEquals(8 ,result3);
        assertEquals(1 ,result4);
    }
}