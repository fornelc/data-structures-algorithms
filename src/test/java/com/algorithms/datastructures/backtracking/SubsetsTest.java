package com.algorithms.datastructures.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubsetsTest {
    private Subsets sut;

    @BeforeEach
    public void setUp() {
        sut = new Subsets();
    }

    @Test
    public void subsets() {
        List<List<Integer>> result = sut.subsets(new int[]{1,2,3});
        assertEquals(1, result.get(1).get(0).intValue());
    }
}
