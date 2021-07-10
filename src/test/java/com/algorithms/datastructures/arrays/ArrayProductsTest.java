package com.algorithms.datastructures.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayProductsTest {
    @Test
    public void TestCase1() {
        var input = new int[] {5, 1, 4, 2};
        var expected = new int[] {8, 40, 10, 20};
        int[] actual = ArrayProducts.arrayOfProducts(input);
        assertTrue(expected.length == actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertTrue(actual[i] == expected[i]);
        }
    }
}
