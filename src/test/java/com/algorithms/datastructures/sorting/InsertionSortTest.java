package com.algorithms.datastructures.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertionSortTest {
    private InsertionSort sut;

    @BeforeEach
    public void setUp() {
        sut = new InsertionSort();
    }

    @Test
    public void insertionSort_returnArraySorted() {
        int[] result = sut.insertionSort(new int[]{8, 5, 2, 9, 5, 6, 3});
        assertArrayEquals(new int[]{2, 3, 5, 5, 6, 8, 9}, result);
    }
}
