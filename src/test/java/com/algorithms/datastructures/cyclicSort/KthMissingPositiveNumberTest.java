package com.algorithms.datastructures.cyclicSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthMissingPositiveNumberTest {

    @Test
    void testFindKthPositive() {
        FindKthPositive finder = new FindKthPositive();
        int[] nums = {2, 3, 4, 7, 11};
        int k = 5;
        int expected = 9;

        int actual = finder.findKthPositive(nums, k);

        assertEquals(expected, actual);
    }
}
