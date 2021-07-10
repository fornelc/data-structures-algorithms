package com.algorithms.datastructures.strings;

public class PalindromeCheck {
    /**
     * Write a function that takes in a non-empty string and that returns a boolean
     * representing whether the string is a palindrome.
     *
     * Time O(n) | Space O(1)
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        boolean result = true;
        while (i<j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Using a String
     *
     * Time O(n^2) | Space O(n)
     * Time is O n square because we are doing these string concatenations which create new strings, which take time.
     * And we are doing a total of N of them, because we are iterating through the entire input string.
     */
    public static boolean isPalindromeString(String str) {
        String reversedString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString += str.charAt(i);
        }
        return str.equals(reversedString);
    }

    /**
     * Using a StringBuilder
     *
     * Time O(n) | Space O(n)
     * Appending in a StringBuilder doesn't create a new string each time, so don't take extra time, it is O(n) time,
     * because we iterate through the n characters of the string.
     */
    public static boolean isPalindromeStringBuilder(String str) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString.append(str.charAt(i));
        }
        return str.equals(reversedString.toString());
    }

    /**
     * Using recursion.
     * Time O(n) | Space O(n)
     *
     * Space is O(n) because in the recursion, each time that the helper method is called, it is used stack space.
     */
    public static boolean isPalindromeRecursion(String str) {
        return isPalindromeHelper(str, 0);
    }

    private static boolean isPalindromeHelper(String str, int i) {
        int j = str.length() - 1 - i;
        if (i >= j) {
            return true;
        } else if (str.charAt(i) != str.charAt(j)) {
            return false;
        } else {
            return isPalindromeHelper(str, i++);
        }
    }
}
