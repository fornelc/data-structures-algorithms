package com.algorithms.datastructures.topKElement;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FindKClosestElementsTest {

    @Test
    public void testFindClosestElements() {
        final FindKClosestElements findKClosestElements = new FindKClosestElements();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, findKClosestElements.findClosestElements(arr, k, x));

        arr = new int[]{1, 2, 3, 4, 5};
        k = 4;
        x = -1;
        expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, findKClosestElements.findClosestElements(arr, k, x));
    }
}
