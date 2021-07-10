package com.algorithms.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistributeCandiesTest {

    private DistributeCandies sut;

    @BeforeEach
    public void setUp() {
        sut = new DistributeCandies();
    }

    @Test
    public void distributeCandies_returnArrayWithCandiesDistributed() {
        DistributeCandies distributeCandies = new DistributeCandies();
//        Assertions.assertArrayEquals(distributeCandies.distributeCandies(7, 4), new int[]{1,2,3,1});
        Assertions.assertArrayEquals(distributeCandies.distributeCandies(12, 3), new int[]{5,4,3});
    }
}
