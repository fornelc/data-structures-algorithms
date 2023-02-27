package com.algorithms.datastructures.cyclicSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindDuplicateTest {

    @Test
    public void testFindDuplicate() {
        FindDuplicate findDuplicate = new FindDuplicate();

        int[] nums1 = {1, 3, 4, 2, 2};
        int result1 = findDuplicate.findDuplicate(nums1);
        assertEquals(2, result1);

        int[] nums2 = {3, 1, 3, 4, 2};
        int result2 = findDuplicate.findDuplicate(nums2);
        assertEquals(3, result2);

        int[] nums3 = {1};
        int result3 = findDuplicate.findDuplicate(nums3);
        assertEquals(-1,result3);
    }
}
