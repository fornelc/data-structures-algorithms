package com.algorithms.datastructures.cyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {


    public List<Integer> findDisappearedNumbers(int[] nums) {
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
            int num = k + 1;

            if (nums[k] != num) {
                result.add(num);
            }
        }

        return result;
    }
}
