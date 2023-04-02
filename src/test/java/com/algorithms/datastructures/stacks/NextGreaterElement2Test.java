package com.algorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NextGreaterElement2Test {

    @Test
    public void testCase() {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        int[] expectedOutput = new int[]{-1,3,-1};

        int[] output = new NextGreaterElement2().nextGreaterElement(nums1, nums2);

        assertArrayEquals(expectedOutput, output);
    }
}
