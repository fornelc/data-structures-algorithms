package com.algorithms.datastructures.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermutationsTest {
    private Permutations sut;

    @BeforeEach
    public void setUp() {
        sut = new Permutations();
    }

    @Test
    public void permute() {
        List<List<Integer>> result = sut.permute(new int[]{1,2,3});
        assertEquals(6, result.size());
    }
}
