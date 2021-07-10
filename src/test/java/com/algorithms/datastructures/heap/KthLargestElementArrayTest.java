package com.algorithms.datastructures.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthLargestElementArrayTest {
    private KthLargestElementArray sut;

    @BeforeEach
    public void setUp() {
        sut = new KthLargestElementArray();
    }

    @Test
    public void findKthLargest() {
        int result = sut.findKthLargest(new int[]{3,2,1,5,6,4}, 2);
        assertEquals(5, result);
    }
}
