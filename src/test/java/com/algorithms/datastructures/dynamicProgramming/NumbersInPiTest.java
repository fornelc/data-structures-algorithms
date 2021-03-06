package com.algorithms.datastructures.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumbersInPiTest {
    String PI = "3141592653589793238462643383279";

    @Test
    public void TestCase1() {
        String[] numbers =
                new String[] {
                        "314159265358979323846", "26433", "8", "3279", "314159265", "35897932384626433832", "79"
                };
        assertTrue(NumbersInPi.numbersInPi(PI, numbers) == 2);
    }

    @Test
    public void TestCase2() {
        String[] numbers =
                new String[] {
                        "3141", "1512", "159", "793", "12412451", "8462643383279"
                };
        assertTrue(NumbersInPi.numbersInPi("3141592653589793238462643383279", numbers) == -1);
    }
}
