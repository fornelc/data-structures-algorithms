package com.algorithms.datastructures.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReverseWordStringSolution1Test {
    @Test
    public void TestCase1() {
        String input = "AlgoExpert is the best!";
        String expected = "best! the is AlgoExpert";
        String actual = new ReverseWordInStringSolution1().reverseWordsInString(input);
        assertTrue(expected.equals(actual));
    }
}
