package com.algorithms.datastructures.topKElement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrequencySortStringTest {

    @Test
    public void testFrequencySort() {
        String input = "tree";
        String expectedOutput = "eert";
        assertEquals(expectedOutput, new FrequencysortString().frequencySort(input));
    }
}
