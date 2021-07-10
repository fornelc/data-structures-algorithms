package com.algorithms.datastructures.famousAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KadaneAlgorithmTest {
    @Test
    public void kadanesAlgorithm_returnMaximumSum() {
        assertEquals(19, KadaneAlgorithm.kadanesAlgorithm(new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4}));
    }
}
