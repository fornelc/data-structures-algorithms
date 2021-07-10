package com.algorithms.datastructures.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonotonicTest {
    @Test
    public void isMonotonicSolution1_returnTrue() {
        assertTrue(Monotonic.isMonotonicSolution1(new int[] {-1,-5,-10,-1100,-1100,-1101,-1102,-9001}));
    }

    @Test
    public void isMonotonicSolution2_returnTrue() {
        assertTrue(Monotonic.isMonotonicSolution2(new int[] {-1,-5,-10,-1100,-1100,-1101,-1102,-9001}));
    }
}
