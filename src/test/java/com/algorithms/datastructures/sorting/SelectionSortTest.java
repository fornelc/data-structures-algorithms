package com.algorithms.datastructures.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortTest {
    @Test
    public void selectionSort_returnArraySorted() {
        int[] result = SelectionSort.selectionSort(new int[]{8, 5, 2, 9, 5, 6, 3});
        assertArrayEquals(new int[]{2, 3, 5, 5, 6, 8, 9}, result);
    }
}
