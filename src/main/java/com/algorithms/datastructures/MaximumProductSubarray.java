package com.algorithms.datastructures;

public class MaximumProductSubarray {
    /**
     * Given an integer array nums, find the contiguous subarray within an array
     * (containing at least one number) which has the largest product.
     *
     * Solution: https://leetcode.com/problems/maximum-product-subarray/solution/
     *
     * Time O(N^2) | Space O(1)
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int result = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int accu = 1;
            for (int j = i; j < nums.length; j++) {
                accu *= nums[j];
                result = Math.max(result, accu);
            }
        }

        return result;
    }

    /**
     * In this solution the key is in the max_so_far and min_so_far fields
     * The reason behind keeping track of max_so_far is to keep track of the accumulated product of positive numbers.
     * The reason behind keeping track of min_so_far is to properly handle negative numbers.
     *
     * Calculating the maximum value in max_so_far, the product of last min_so_far and current number, will give as maximum value
     * in case that is multiplying two negative numbers.
     * Time O(n) | Space O(1)
     * @param nums
     * @return
     */
    public int maxProductApproach2(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }

        return result;
    }

}
