package com.algorithms.datastructures.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinNumberOfCoinsForChangeTest {

    private MinNumberOfCoinsForChange sut;

    @Test
    public void minNumberOfCoinsForChange_returnMinNumberOfCoins() {
        assertEquals(3, sut.minNumberOfCoinsForChange(7, new int[]{1,5,10}));
    }
}
