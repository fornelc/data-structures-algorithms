package com.algorithms.datastructures.cyclicSort;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int j = nums[i] - 1;

            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1) {
                return k + 1;
            }
        }

        return nums.length + 1;
    }
}
