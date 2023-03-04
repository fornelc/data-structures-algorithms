package com.algorithms.datastructures.topKElement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindKthLargestTest {

    @Test
    public void testFindKthLargest() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int expected = 5;
        assertEquals(expected, new FindKthLargest().findKthLargest(nums, k));
    }
}
