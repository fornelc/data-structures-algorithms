package com.algorithms.datastructures.arrays;

public class Monotonic {
    /**
     * https://www.algoexpert.io/questions/Monotonic%20Array
     * Write a function that takes in an array of integers and returns a boolean
     * representing whether the array is monotonic.
     * Sample input
     * array = [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]
     * Sample output
     * true
     *
     * How to solve it
     * You can start by checking the two first values of the array,
     * if the second element of the array is greater than the first one
     * then the rest of the array should be increasing,
     * so the direction of the array should be increasing, otherwise it should be decreasing.
     *
     * Solution1:
     * Try iterating through the input array from left to right, in search of two adjacent integers
     * that can indicate whether the array is trending upward or downward.
     * Once you've found the tentative trend of the array, at each element thereafter,
     * compare the element to the previous one; if this comparison breaks the previously identified trend,
     * the array isn't monotonic.
     *
     * Solution2:
     * You can start by assuming that the array is both entirely non-decreasing and entirely non-increasing.
     * As you iterate through each element, perform a check to see if you can invalidate one or both of your assumptions.
     *
     * O(n) time | O(1) space - where n is the length of the array
     */
    public static boolean isMonotonicSolution1(int[] array) {
        if (array.length <= 2) {
            return true;
        }
        int direction = array[1] - array[0];
        for(int i = 2; i < array.length; i++) {
            if (direction == 0) {
                direction = array[i] - array[i - 1];
                continue;
            }
            if (breaksTrend(direction, array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean breaksTrend(int direction, int current, int previous) {
        int difference = current - previous;
        if (direction > 0) {
            return difference < 0;
        }
        return difference > 0;
    }

    public static boolean isMonotonicSolution2(int[] array) {
        boolean isNonIncreasing = true;
        boolean isNonDecreasing = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                isNonDecreasing = false;
            } else if (array[i] > array[i -1]) {
                isNonIncreasing = false;
            }

        }
        return isNonIncreasing || isNonDecreasing;
    }
}
