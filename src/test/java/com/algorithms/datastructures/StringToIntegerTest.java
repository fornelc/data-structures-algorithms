package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringToIntegerTest {
    private StringToInteger sut;

    @BeforeEach
    public void setUp() {
        sut = new StringToInteger();
    }

    @Test
    public void myAtoi() {
//        assertEquals(42, sut.myAtoi("42"));
//        assertEquals(-42, sut.myAtoi("   -42"));
//        assertEquals(4193, sut.myAtoi("4193 with words"));
//        assertEquals(0, sut.myAtoi("words and 987"));
        assertEquals(-2147483648, sut.myAtoi("-91283472332"));
        assertEquals(2147483647, sut.myAtoi("2147483647"));
        assertEquals(2147483647, sut.myAtoi("2147483648"));
        assertEquals(2147483646, sut.myAtoi("2147483646"));
        assertEquals(-2147483648, sut.myAtoi("-2147483648"));
    }
}
