package com.algorithms.datastructures;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumDistanceInArraysTest {
    @Test
    public void maxDistance_returnsMaxDistance() {
        MaximumDistanceInArrays maxDis = new MaximumDistanceInArrays();
        assertEquals(maxDis.maxDistance(buildArrays()),4);
    }

    private List<List<Integer>> buildArrays() {
        List<List<Integer>> arrays = new ArrayList<>();
        List<Integer> nums1 = new ArrayList<>();
        nums1.add(1);
        nums1.add(2);
        nums1.add(3);
        arrays.add(nums1);
        List<Integer> nums2 = new ArrayList<>();
        nums2.add(4);
        nums2.add(5);
        arrays.add(nums2);
        List<Integer> nums3 = new ArrayList<>();
        nums3.add(1);
        nums3.add(2);
        nums3.add(3);
        arrays.add(nums3);

        return arrays;
    }
}
