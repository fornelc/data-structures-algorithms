package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuySellStockTest {
    private BestTimeToBuySellStock sut;

    @BeforeEach
    public void setUp() {
        sut = new BestTimeToBuySellStock();
    }

    @Test
    public void maxProfit() {
        assertEquals(sut.maxProfit(new int[]{7,1,5,3,6,4}), 5);
        assertEquals(sut.maxProfit(new int[]{7,6,4,3,1}), 0);
    }
}
