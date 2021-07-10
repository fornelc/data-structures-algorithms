package com.algorithms.datastructures.arrays;

/**
 * https://www.algoexpert.io/questions/Longest%20Peak
 * Write a function that takes in an array of integers and returns the length of
 * the longest peak in the array.
 *
 * Sample Input
 * array = [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]
 *
 * Sample Output
 * 6 // 0, 10, 6, 5, -1, -3
 *
 * How to solve:
 * Iterate through the array from left to right,
 * and treat every integer as the potential tip of a peak.
 * To be the tip of a peak, an integer has to be strictly greater than its adjacent integers.
 *
 * As you iterate through the array from left to right, whenever you find a tip of a peak,
 * expand outwards from the tip until you no longer have a peak.
 * Given what peaks look like and how many peaks can therefore fit in an array,
 * realize that this process results in a linear-time algorithm.
 * Make sure to keep track of the longest peak you find as you iterate through the array.
 *
 * O(n) time | O(1) space - where n is the length of the input array
 * When expanding outwards you will be revisiting the integers at the left, at most only two or three times.
 * In the right side, we will jump in to the next index element after we have iterated through the array,
 * to calculate the peak length, so no integer is revisited in the right side.
 * So no more than O(2n) or O(3n) and this is simplified into O(n) time.
 */
public class LongestPeak {
    public static int longestPeak(int[] array) {
        int greaterPeakLength = 0;
        int i = 1;
        while (i < array.length - 1) {
            boolean isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];
            if (!isPeak) {
                i++;
                continue;
            }
            // We check the left side of the peak
            int leftMostPeak = i - 2;
            while (leftMostPeak >= 0 && array[leftMostPeak] < array[leftMostPeak + 1]) {
                leftMostPeak--;
            }
            // We check the right side of the peak
            int rightMostPeak = i + 2;
            while (rightMostPeak < array.length && array[rightMostPeak] < array[rightMostPeak - 1]) {
                rightMostPeak++;
            }
            // We have to subtract one element, as the last leftMostPeak is decreased
            // or rightMostPeak is increased, before checking if they belong to the peak.
            int peakLength = rightMostPeak - leftMostPeak - 1;
            greaterPeakLength = Math.max(greaterPeakLength, peakLength);

            // We jump in directly to the right most peak found to continue the loop
            i = rightMostPeak;
        }
        return greaterPeakLength;
    }
}
