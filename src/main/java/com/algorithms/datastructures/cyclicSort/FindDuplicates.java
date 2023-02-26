package com.algorithms.datastructures.cyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        final List<Integer> result = new ArrayList<>();
        int i = 0;

        while (i < nums.length) {
            int j = nums[i] - 1;

            if (nums[j] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1) {
                result.add(nums[k]);
            }
        }

        return result;
    }
}
