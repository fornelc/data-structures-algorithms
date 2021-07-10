package com.algorithms.datastructures.dynamicProgramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfWaysToMakeChangeRecursiveSolutionTest {

    private NumberOfWaysToMakeChangeRecursiveSolution sut;

    @BeforeEach
    public void setUp() {
        sut = new NumberOfWaysToMakeChangeRecursiveSolution();
    }

    @Test
    public void comboReturnNumberOfWays() {
        assertEquals(3, sut.combo(4, 0));
    }
}
