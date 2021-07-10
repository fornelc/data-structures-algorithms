package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciNumberTest {
    private FibonacciNumber sut;

    @BeforeEach
    public void setUp() {
        sut = new FibonacciNumber();
    }

    @Test
    public void fib() {
        assertEquals(13, sut.fib(7));
        assertEquals(1, sut.fib(2));
        assertEquals(2, sut.fib(3));
        assertEquals(3, sut.fib(4));
    }
}
