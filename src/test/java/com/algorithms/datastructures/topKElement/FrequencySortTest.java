package com.algorithms.datastructures.topKElement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FrequencySortTest {

    @Test
    public void testFrequencySort() {
        FrequencySort fs = new FrequencySort();
        int[] input = {1, 1, 2, 2, 2, 3};
        int[] expectedOutput = {3 ,1 ,1 ,2 ,2 ,2};
        assertArrayEquals(expectedOutput, fs.frequencySort(input));
    }
}
