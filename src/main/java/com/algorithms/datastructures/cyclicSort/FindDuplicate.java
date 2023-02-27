package com.algorithms.datastructures.cyclicSort;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            if (nums[i] != i + 1) {
                int j = nums[i] - 1;
                if (nums[i] != nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }

        return -1;
    }
}
