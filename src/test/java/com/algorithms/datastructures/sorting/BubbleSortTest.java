package com.algorithms.datastructures.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortTest {
    private BubbleSort sut;

    @BeforeEach
    public void setUp() {
        sut = new BubbleSort();
    }

    @Test
    public void bubbleSort_returnArraySorted() {
        int[] result = sut.bubbleSort(new int[]{8,5,2,9,5,6,3});
        assertEquals(2, result[0]);
        assertEquals(3, result[1]);
        assertEquals(5, result[2]);
        assertEquals(5, result[3]);
        assertEquals(6, result[4]);
        assertEquals(8, result[5]);
        assertEquals(9, result[6]);
    }
}
