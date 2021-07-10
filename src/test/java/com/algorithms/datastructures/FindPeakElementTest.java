package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindPeakElementTest {
    private FindPeakElement sut;

    @BeforeEach
    public void setUp() {
        sut = new FindPeakElement();
    }

    @Test
    public void findPeakElement() {
        assertEquals(5, sut.findPeakElement(new int[]{1,2,1,3,5,6,4}));
        assertEquals(2, sut.findPeakElement(new int[]{1,2,3,1}));
        assertEquals(0, sut.findPeakElement(new int[]{1}));
        assertEquals(1, sut.findPeakElement(new int[]{1,2}));
        assertEquals(0, sut.findPeakElement(new int[]{2,1}));
        assertEquals(0, sut.findPeakElement(new int[]{3,2,1}));
    }
}
