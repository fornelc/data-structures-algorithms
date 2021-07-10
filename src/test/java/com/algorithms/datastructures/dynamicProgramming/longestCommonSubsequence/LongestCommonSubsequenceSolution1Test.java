package com.algorithms.datastructures.dynamicProgramming.longestCommonSubsequence;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LongestCommonSubsequenceSolution1Test {
    @Test
    public void TestCase1() {
        char[] expected = {'X', 'Y', 'Z', 'W'};
        assertTrue(compare(LongestCommonSubsequenceSolution1.longestCommonSubsequence("ZXVVYZW", "XKYKZPW"), expected));
    }

    @Test
    public void TestCase2() {
        char[] expected = {'n', 't'};
        assertTrue(compare(LongestCommonSubsequenceSolution1.longestCommonSubsequence("clement", "antoine"), expected));
    }

    @Test
    public void TestCase3() {
        char[] expected = {'8', '4', '2'};
        assertTrue(compare(LongestCommonSubsequenceSolution1.longestCommonSubsequence("8111111111111111142", "222222222822222222222222222222433333333332"), expected));
    }

    private static boolean compare(List<Character> arr1, char[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
