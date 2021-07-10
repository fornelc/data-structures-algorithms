package com.algorithms.datastructures;

public class FindPeakElement {
    /**
     * A peak element is an element that is greater than its neighbors.
     * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
     * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
     * You may imagine that nums[-1] = nums[n] = -∞.
     *
     * Example 1:
     * Input: nums = [1,2,3,1]
     * Output: 2
     * Explanation: 3 is a peak element and your function should return the index number 2.
     *
     * Solution: https://leetcode.com/problems/find-peak-element/solution/
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }
}
