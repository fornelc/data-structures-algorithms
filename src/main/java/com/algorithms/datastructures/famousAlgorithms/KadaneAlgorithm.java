package com.algorithms.datastructures.famousAlgorithms;

/**
 * Problem: https://www.algoexpert.io/questions/Kadane's%20Algorithm
 *
 * How to solve:
 *
 * This algorithm makes use of dynamic programming.
 * Realize that at any given index in the input array,
 * the maximum sum for a subarray ending at that index
 * is either the maximum sum for a subarray ending at the previous index plus the number at that index,
 * or just the number at that index. Thus, for each index in the array,
 * you can calculate the maximum sum of a subarray ending at that index,
 * and this can be done in one simple pass through the input array.
 *
 * To obtain the maximum sum, we keep track of the maximum sum retrieved from the formula of calculating the
 * maximum sum for a subarray ending at the previous index plus the number at that index, or just the number at that index.
 *
 * Space & Time complexity
 *
 * Time O(n) where n is the length of the input array.
 * Space O(1) - you're literally not storing anything except for the two values maxEndingHere and maxSoFar.
 */
public class KadaneAlgorithm {
    public static int kadanesAlgorithm(int[] array) {
        int maxEndingHere = array[0];
        int maxSoFar = array[0];

        for (int i = 1; i < array.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + array[i], array[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
