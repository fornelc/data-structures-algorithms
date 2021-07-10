package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumProductSubarrayTest {
    private MaximumProductSubarray sut;

    @BeforeEach
    public void setUp() {
        sut = new MaximumProductSubarray();
    }

    @Test
    public void maxProduct() {
        assertEquals(6, sut.maxProduct(new int[]{2,3,-2,4}));
        assertEquals(-2, sut.maxProduct(new int[]{-2}));
        assertEquals(24, sut.maxProduct(new int[]{-2,3,-4}));
        assertEquals(2, sut.maxProduct(new int[]{0,2}));
        assertEquals(24, sut.maxProduct(new int[]{2,-5,-2,-4,3}));
    }

    @Test
    public void maxProductApproach2() {
        assertEquals(6, sut.maxProductApproach2(new int[]{2,3,-2,4}));
        assertEquals(-2, sut.maxProductApproach2(new int[]{-2}));
        assertEquals(24, sut.maxProductApproach2(new int[]{-2,3,-4}));
        assertEquals(2, sut.maxProductApproach2(new int[]{0,2}));
        assertEquals(24, sut.maxProductApproach2(new int[]{2,-5,-2,-4,3}));
    }
}
