package com.algorithms.datastructures.topKElement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TopFrequentTest {

    @Test
    public void testTopKFrequent() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] expected = {1, 2};
        assertArrayEquals(expected, new TopKFrequent().topKFrequent(nums, k));
    }
}
