package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistributeCandies2Test {

    private DistributeCandies2 sut;

    @BeforeEach
    public void setUp() {
        sut = new DistributeCandies2();
    }

    @Test
    public void solution_returnCandies() {
        assertEquals(sut.solution(new int[] {3,4,7,7,6,6}), 3);
        assertEquals(sut.solution(new int[] {80, 80, 1000000000, 80, 80, 80, 80, 80, 80, 123456789}), 3);
    }

}
