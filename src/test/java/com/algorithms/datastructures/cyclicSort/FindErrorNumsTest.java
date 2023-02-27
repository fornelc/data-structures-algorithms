package com.algorithms.datastructures.cyclicSort;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindErrorNumsTest {

    private FindErrorNums sut;

    @BeforeEach
    public void setUp() {
        sut = new FindErrorNums();
    }

    @Test
    public void testFindErrorNums() {
        int[] nums1 = {1, 2, 2, 4};
        int[] expected1 = {2, 3};
        int[] nums2 = {3, 2, 4, 1};
        int[] expected2 = {};
        int[] nums3 = {};
        int[] expected3 = {};
        int[] nums4 = {5, 5, 6, 6};
        int[] expected4 = {5, 1};

        assertArrayEquals(expected1, sut.findErrorNums(nums1));
        assertArrayEquals(expected2, sut.findErrorNums(nums2));
        assertArrayEquals(expected3, sut.findErrorNums(nums3));
        assertArrayEquals(expected4, sut.findErrorNums(nums4));
    }
}
