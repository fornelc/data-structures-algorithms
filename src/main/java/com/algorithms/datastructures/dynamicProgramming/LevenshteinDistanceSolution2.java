package com.algorithms.datastructures.dynamicProgramming;

/**
 * Problem: https://www.algoexpert.io/questions/Levenshtein%20Distance
 *
 * How to solve:
 * Instead of storing all the two dimensional array as in the previous solution,
 * identify what stored values you actually use throughout the process of building the array
 * and come up with a way of storing only what you need and nothing more.
 *
 * Basically at any given point all we need are the two final rows. So instead of storing the entire 2D array,
 * we just store two rows. So the space complexity instead of being O(nm) would be O(n) or O(m), depending of
 * what string we put at the top as columns, our space complexity would have length of M or N.
 *
 * But the truth is we could put whichever string we want on the top. We could put any of the strings as columns
 * or we could put them as rows.
 *
 * So what we are gonna do is to take the string that has the smallest length to the top as columns,
 * so that way we get a smaller space complexity.
 *
 * Space & Time complexity:
 * O(nm) time | O(min(n, m)) space, where n and m are string1 and string2
 */
public class LevenshteinDistanceSolution2 {
    // The main difference with the other solution is how we kind of initialize everything
    public static int levenshteinDistance(String str1, String str2) {
        String small = str1.length() < str2.length() ? str1 : str2;
        String big = str1.length() >= str2.length() ? str1 : str2;
        int[] evenEdits = new int[small.length() + 1];
        int[] oddEdits = new int[small.length() + 1];
        for (int j = 0; j <= small.length(); j++) {
            evenEdits[j] = j;
        }

        int[] currentEdits;
        int[] previousEdits;
        for (int i = 1; i <= big.length(); i++) {
            if (i % 2 == 1) {
                currentEdits = oddEdits;
                previousEdits = evenEdits;
            } else {
                currentEdits = evenEdits;
                previousEdits = oddEdits;
            }
            // Here we make the trick to set the value for the first column of each row.
            currentEdits[0] = i;
            for (int j = 1; j <= small.length(); j++) {
                if (big.charAt(i - 1) == small.charAt(j - 1)) {
                    currentEdits[j] = previousEdits[j - 1];
                } else {
                    currentEdits[j] = 1 + Math.min(previousEdits[j - 1], Math.min(previousEdits[j], currentEdits[j - 1]));
                }
            }
        }
        return big.length() % 2 == 0 ? evenEdits[small.length()] : oddEdits[small.length()];
    }
}
