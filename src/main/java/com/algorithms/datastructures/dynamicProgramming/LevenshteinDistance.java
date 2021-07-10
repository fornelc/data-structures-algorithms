package com.algorithms.datastructures.dynamicProgramming;

/**
 * Link that helped me to understand better the problem:
 * https://www.youtube.com/watch?v=b6AGUjqIPsA&list=PLpTCs99QhuIHYnm4Rad7YSf_pcuVGIl1H&index=5&t=868s
 *
 * Problem: https://www.algoexpert.io/questions/Levenshtein%20Distance
 *
 * How to solve:
 * Try building a two-dimensional array of the minimum numbers of edits for pairs of substrings of the input strings.
 * Let the rows of the array represent substrings of the second input string str2.
 * Let the first row represent the empty string. Let each row i thereafter represent the substrings of str2 from 0 to i,
 * with i excluded. Let the columns similarly represent the first input string str1.
 *
 * Build up the array one row at a time. In other words, find the minimum numbers of edits
 * between all the substrings of str1 represented by the columns and the empty string represented by the first row,
 * then between all the substrings of str1 represented by the columns and the first letter of str2 represented by the second row, etc.,
 * until you compare both full strings. Find a formula that relates the minimum number of edits at any given point to previous numbers.
 *
 * At any position (i, j) in the two-dimensional array, if str2[i] is equal to str1[j],
 * then the edit distance at position (i, j) is equal to the one at position (i - 1, j - 1),
 * since adding str2[i] and str1[j] to the substrings represented at position (i - 1, j - 1) does not require any additional edit operation.
 * If str2[i] is not equal to str1[j] however, then the edit distance at position (i, j) is equal to
 * 1 + the minimum of the edit distances at positions (i - 1, j), (i, j - 1), and (i - 1, j - 1).
 * So the minimum edit distance to the substrings represented at each neighbor position,
 * plus adding 1 edit distance of adding str2[i] and str1[j] to the minimum edit substring distance.
 *
 * Space & Time complexity:
 * O(nm) time | O(nm) space - where n and m are string1 and string2
 */
public class LevenshteinDistance {
    public static int levenshteinDistance(String str1, String str2) {
        int[][] distanceArray = new int[str2.length()+1][str1.length()+1];
        for (int row = 1; row <= str2.length(); row++) {
            for (int col = 1; col <= str1.length(); col++) {
                distanceArray[0][col] = col;
            }
            distanceArray[row][0] = row;
        }
        for (int row = 1; row <= str2.length(); row++) {
            for (int col = 1; col <= str1.length(); col++) {
                //col -1 and row -1 to get the letter of the string, because we shifted by one,
                // in the columns and rows because of the empty string. So the letter that we are looking
                // for in the table would be at index i minus one
                if (str1.charAt(col - 1) == str2.charAt(row - 1)) {
                    distanceArray[row][col] = distanceArray[row-1][col-1];
                } else {
                    distanceArray[row][col] = 1 + Math.min(distanceArray[row-1][col-1],
                            Math.min(distanceArray[row][col-1], distanceArray[row-1][col]));
                }
            }
        }
        return distanceArray[str2.length()][str1.length()];
    }
}
