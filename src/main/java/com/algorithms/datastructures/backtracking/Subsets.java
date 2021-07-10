package com.algorithms.datastructures.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /**
     * Given an integer array nums, return all possible subsets (the power set).
     * The solution set must not contain duplicate subsets.
     *
     * Solution: https://leetcode.com/problems/subsets/solution/
     *
     * Time complexity: O(N x 2^N) to generate all subsets and then copy them into output list.
     * Space complexity: O(N x 2^N) to keep all the subsets of length N, since each of N elements could be present or absent.
     *
     * @param nums
     * @return
     */
    List<List<Integer>> output = new ArrayList();
    int n, k;

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k)
            output.add(new ArrayList(curr));

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }
}
