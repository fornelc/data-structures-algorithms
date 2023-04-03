package com.algorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DailyTemperaturesTest {

    @Test
    public void testCase() {
       int[] input = new int[]{73,74,75,71,69,72,76,73};
       int[] expectedOutput = new int[]{1,1,4,2,1,1,0,0};

       int[] output = new DailyTemperatures().dailyTemperatures(input);

       assertArrayEquals(expectedOutput, output);
    }
}
