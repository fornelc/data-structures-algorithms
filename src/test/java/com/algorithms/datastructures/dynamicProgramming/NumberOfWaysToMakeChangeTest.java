package com.algorithms.datastructures.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfWaysToMakeChangeTest {

    private NumberOfWaysToMakeChange sut;

    @Test
    public void comboReturnNumberOfWays() {
        assertEquals(2, sut.numberOfWaysToMakeChange(6, new int[]{1,5}));
        assertEquals(1, sut.numberOfWaysToMakeChange(0, new int[]{2,3,4,7}));
    }
}
