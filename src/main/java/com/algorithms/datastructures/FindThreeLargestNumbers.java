package com.algorithms.datastructures;

public class FindThreeLargestNumbers {
    /**
     * Exercise: https://www.algoexpert.io/questions/Find%20Three%20Largest%20Numbers
     * Write a function that takes in an array of at least three integers and,
     * without sorting the input array, returns a sorted array of the three largest
     * integers in the input array.
     *
     * The function should return duplicate integers if necessary; for example, it
     * should return [10, 10, 12] for an input array of
     * [10, 5, 9, 10, 12]
     *
     * Sample Input: [141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7]
     * Sample Output: [18, 141, 541]
     *
     * Time: O(n) | Space: O(1)
     * Because we have to traverse the entire array, we're doing constant time operations at every point in the array,
     * and we're not storing anything but these three largest numbers, which don't take much space at all.
     *
     * @param array
     * @return
     */
    public int[] findThreeLargestNumbers(int[] array) {
        int[] nums = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : array) {
            updateThreeLargestNumbers(num, nums);
        }
        return nums;
    }

    private void updateThreeLargestNumbers(int num, int[] nums) {
        if (num > nums[2]) {
            updateAndShiftNumbers(num, nums, 2);
        } else if (num > nums[1]) {
            updateAndShiftNumbers(num, nums, 1);
        } else if (num > nums[0]) {
            updateAndShiftNumbers(num, nums, 0);
        }
    }

    private void updateAndShiftNumbers(int num, int[] nums, int index) {
        for (int i = 0; i <= index; i ++) {
            if (index == i) {
                nums[i] = num;
            } else {
                nums[i] = nums[i + 1];
            }
        }
    }
}
