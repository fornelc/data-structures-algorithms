package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombinationSumTest {

    private CombinationSum sut;

    @BeforeEach
    public void setUp() {
        sut = new CombinationSum();
    }

    @Test
    public void combinationSum() {
        List<List<Integer>> combinations = sut.combinationSum(new int[]{2,3,6,7}, 7);
        assertEquals(combinations.size(), 2);
        List<Integer> combination = new ArrayList<>(Arrays.asList(2, 2, 3));
        assertArrayEquals(combinations.get(0).toArray(), combination.toArray());
        combination = new ArrayList<>(Arrays.asList(7));
        assertArrayEquals(combinations.get(1).toArray(), combination.toArray());
    }
}
