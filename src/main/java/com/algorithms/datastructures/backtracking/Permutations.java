package com.algorithms.datastructures.backtracking;

import java.util.*;

public class Permutations {

    private void backtrack(final int n,
                          final ArrayList<Integer> nums,
                          final List<List<Integer>> output,
                          final int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    /**
     * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
     * Solution: https://leetcode.com/problems/permutations/solution/
     *
     * Time complexity: O(N!)
     * Space complexity: O(N!)
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }
}
