package com.algorithms.datastructures.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleCycleCheckTest {
    @Test
    public void hasSingleCycle_returnIfSingleCycle() {
        assertEquals(true, SingleCycleCheck.hasSingleCycle(new int[]{2,3,1,-4,-4,2}));
    }
}
