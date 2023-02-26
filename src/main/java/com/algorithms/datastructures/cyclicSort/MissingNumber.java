package com.algorithms.datastructures.cyclicSort;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i];

            if (j < nums.length && nums[i] != i) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k) {
                return k;
            }
        }

        return nums.length;
    }
}
