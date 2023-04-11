package com.algorithms.datastructures.arrays;

import java.util.*;

public class ThreeSum {

    /**
     * Algo expert: https://www.algoexpert.io/questions/Three%20Number%20Sum
     * This problem is really important to know and understand,
     * because I will be using the logic of this problem in a lot of more different problems.
     *
     * How to solve:
     * Try sorting the array and traversing it once.
     * At each number, place a left pointer on the number immediately to the right of your current number
     * and a right pointer on the final number in the array.
     * Check if the current number, the left number, and the right number sum up to the target sum.
     *
     * Depending on the size of each triplet's
     * (current number, left number, right number) sum relative to the target sum,
     * you should either move the left pointer, the right pointer, or both to obtain a potentially valid triplet.
     *
     * Time O(n^2) | Space O(n)
     * O n squared because we are iterating through the main array once, and then for each number we're gonna perform
     * a while loop with the left pointer and the right pointer. The left and right pointer kind of iterate
     * through the rest of the array once. So that's gonna be kind of the equivalent of the double for loop and it's
     * gonna end up being o n squared time.
     * O(n) space because we might end up storing every single number in our array.
     */
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> res = new ArrayList<>();
        for (int i=0; i < array.length-2; i++) {
            helperSum(i, array, targetSum, res);
        }
        return res;
    }

    private static void helperSum(int i, int[] array, int target, List<Integer[]> res) {
        int left = i + 1;
        int right = array.length - 1;
        while (left < right) {
            int sum = array[i] + array[left] + array[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                res.add(new Integer[]{array[i], array[left], array[right]});
                left++;
                right--;
            }
        }
    }

    /**
     * Next to develop 3Sum Smaller and 3sum Closest
     */
    /**
     * 1. Two Pointers Approach
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     * Notice that the solution set must not contain duplicate triplets.
     *
     * https://leetcode.com/problems/3sum/solution/
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }
        return res;
    }

    private static void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }

    /**
     * 2. Hashset approach
     * In -nums[i] - nums[j], we calculate the opposite, for example you can check
     * 5 = -(-3) -(-2) means that if I sum 5 + (-3) + (-2) gives zero.
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumApproach2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        return res;
    }

    private static void twoSum(int[] nums, int i, List<List<Integer>> res) {
        var seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1])
                    ++j;
            }
            seen.add(nums[j]);
        }
    }

    /**
     * 3. No-Sort Approach
     * seen.get(complement) == i is used because you're interested in the compliment found for i number.
     * It could be that the hash map contains the compliment, but it was found before for another number.
     * In that case the compliment shouldn't be used.
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumApproach3(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        return new ArrayList(res);
    }
}
