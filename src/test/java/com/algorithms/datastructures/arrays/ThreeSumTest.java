package com.algorithms.datastructures.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreeSumTest {

    @Test
    public void threeNumberSum_returnListWithSumArrays() {
        int[] array = new int[]{12,3,1,2,-6,5,-8,6};
        assertArrayEquals(new Integer[]{-8,2,6}, ThreeSum.threeNumberSum(array, 0).get(0));
        assertArrayEquals(new Integer[]{-8,3,5}, ThreeSum.threeNumberSum(array, 0).get(1));
        assertArrayEquals(new Integer[]{-6,1,5}, ThreeSum.threeNumberSum(array, 0).get(2));
        assertArrayEquals(new Integer[]{5,6,12}, ThreeSum.threeNumberSum(array, 23).get(0));
        array = new int[]{1,2,3};
        assertArrayEquals(new Integer[]{1,2,3}, ThreeSum.threeNumberSum(array, 6).get(0));
    }

    @Test
    public void threeSum() {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = ThreeSum.threeSum(nums);
        assertEquals(-1, (int) result.get(0).get(0));
        assertEquals(-1, (int) result.get(0).get(1));
        assertEquals(2, (int) result.get(0).get(2));
    }

    @Test
    public void threeSumApproach2() {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = ThreeSum.threeSumApproach2(nums);
        assertEquals(-1, (int) result.get(0).get(0));
        assertEquals(1, (int) result.get(0).get(1));
        assertEquals(0, (int) result.get(0).get(2));
    }

    @Test
    public void threeSumApproach3() {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = ThreeSum.threeSumApproach3(nums);
        assertEquals(-1, (int) result.get(0).get(0));
        assertEquals(-1, (int) result.get(0).get(1));
        assertEquals(2, (int) result.get(0).get(2));
    }
}
