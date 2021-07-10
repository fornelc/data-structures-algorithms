package com.algorithms.datastructures.arrays;

import java.util.Arrays;

public class SmallestDifference {
    /**
     * https://www.algoexpert.io/questions/Smallest%20Difference
     *
     * How to solve it:
     * Start by sorting both arrays. Put a pointer at the beginning of both arrays
     * and evaluate the absolute difference of the pointer-numbers.
     * If the difference is equal to zero, then you've found the closest pair;
     * otherwise, increment the pointer of the smaller of the two numbers
     * to find a potentially better pair.
     * Continue until you get a pair with a difference of zero
     * or until one of the pointers gets out of range of its array.
     *
     *
     * O(nlog(n) + mlog(m)) time | O(1) space
     * where n is the length of the first input array and m is the length of the second input array
     * And the reason it is O(nlog(n) + mlog(m)), it is because we are sorting both arrays.
     * And if we use an optima sorting algorithm like Quicksort, or MergeSort, the time complexity to sort
     * the array is gonna be nlog(n) for array1 and mlog(m) for array2.
     * And the pointer logic time complexity, as we iterate through all the numbers, once in total,
     * in total it is roughly O(n+m) time, which doesn't really affect the overall time complexity,
     * which is really dictated by the sorting of the arrays at the beginning.
     *
     * Space is going to be equal to O(1) constant time, because we're sorting the arrays in place
     * and we're not storing any additional memory, we're just keeping track of our best pair and
     * our smallest difference, but that's all constant space.
     * @param arrayOne
     * @param arrayTwo
     * @return
     */
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int idx1 = 0;
        int idx2 = 0;
        int smallest = Integer.MAX_VALUE;
        int current;
        int[] currentPair = new int[2];
        while (idx1 < arrayOne.length && idx2 < arrayTwo.length) {
            int firstNum = arrayOne[idx1];
            int secondNum = arrayTwo[idx2];
            if (arrayOne[idx1] < arrayTwo[idx2]) {
                current = arrayTwo[idx2] - arrayOne[idx1];
                idx1++;
            } else if (arrayTwo[idx2] < arrayOne[idx1]) {
                current = arrayOne[idx1] - arrayTwo[idx2];
                idx2++;
            } else {
                return new int[]{arrayOne[idx1], arrayTwo[idx2]};
            }
            if (smallest > current) {
                smallest = current;
                currentPair = new int[]{firstNum, secondNum};
            }
        }
        return currentPair;
    }
}
