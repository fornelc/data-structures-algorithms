package com.algorithms.datastructures.strings;

/**
 * Source: https://www.algoexpert.io/questions/Longest%20Palindromic%20Substring
 */
public class LongestPalindromicSubstring {
    public static String longestPalindromicSubstring(String str) {
        int[] currentLongest = new int[] {0, 1};
        for (int i = 1; i < str.length(); i++) {
            int[] even = getPalindromeSubstring(str, i-1, i); // its center is an empty string
            int[] odd = getPalindromeSubstring(str, i-1, i+1); // its center is a character
            int[] tempCurrentLongest = even[1] - even[0] > odd[1] - odd[0] ? even : odd;
            currentLongest = tempCurrentLongest[1] - tempCurrentLongest[0] > currentLongest[1] - currentLongest[0] ?
                    tempCurrentLongest : currentLongest;
        }
        return str.substring(currentLongest[0], currentLongest[1]);
    }

    private static int[] getPalindromeSubstring(String str, int i, int j) {
        while (i >= 0 && j < str.length()) {
            if (str.charAt(i) != str.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        return new int[] {i + 1, j}; // here we don't substract one to j, because when calling to the substring method
                                     // the second parameter is exclusive, meaning that if here we call j - 1,
                                     // then in the substring method we would have to call j + 1
    }
}
