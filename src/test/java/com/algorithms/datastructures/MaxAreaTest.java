package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxAreaTest {
    private MaxArea sut;

    @BeforeEach
    public void setUp() {
        sut = new MaxArea();
    }

    @Test
    public void maxArea() {
        assertEquals(49, sut.maxAreaBruteForce(new int[]{1,8,6,2,5,4,8,3,7}));
        assertEquals(17, sut.maxAreaBruteForce(new int[]{2,3,4,5,18,17,6}));
        assertEquals(24, sut.maxAreaBruteForce(new int[]{1,3,2,5,25,24,5}));
    }
}
