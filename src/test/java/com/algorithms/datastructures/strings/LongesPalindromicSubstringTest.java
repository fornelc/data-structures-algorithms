package com.algorithms.datastructures.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LongesPalindromicSubstringTest {
    @Test
    public void TestCase1() {
        assertTrue(LongestPalindromicSubstring.longestPalindromicSubstring("abaxyzzyxf").equals("xyzzyx"));
    }
}
