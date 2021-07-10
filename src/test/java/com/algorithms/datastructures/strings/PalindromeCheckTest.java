package com.algorithms.datastructures.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeCheckTest {
    @Test
    public void isPalindrome_returnTrue() {
        assertTrue(PalindromeCheck.isPalindrome("abcdcba"));
    }
}
