package com.algorithms.datastructures.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubarraySortTest {
    @Test
    public void TestCase1() {
        int[] expected = {3, 9};
        assertTrue(
                Arrays.equals(
                        SubarraySort.subarraySort(new int[] {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19}),
                        expected));
    }

    @Test
    public void TestCase2() {
        int[] expected = {0, 1};
        assertTrue(
                Arrays.equals(
                        SubarraySort.subarraySort(new int[] {2, 1}),
                        expected));
    }
}
