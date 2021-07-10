package com.algorithms.datastructures;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i+1 };
            }
            map.put(numbers[i], i+1);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Approach 1: Two Pointers
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/solution/
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSumApproach1(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target)
                return new int[]{low + 1, high + 1};
            else if (sum < target)
                ++low;
            else
                --high;
        }
        return new int[]{-1, -1};
    }
}
