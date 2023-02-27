package com.algorithms.datastructures.cyclicSort;

public class FindErrorNums {


    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int i = 0;

        while (i < nums.length) {
            int j = nums[i] - 1;
            if (j < nums.length && nums[j] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1) {
                return new int[] {nums[k], k + 1};
            }
        }

        return new int[0];
    }
}
