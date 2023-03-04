package com.algorithms.datastructures.cyclicSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindKthPositive {
    public int findKthPositive(int[] nums, int k) {
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

        final List<Integer> missingNumbers = new ArrayList<>();
        final Set<Integer> extraNumbers = new HashSet<>();

        for (i = 0; i < nums.length; i++) {
            if (missingNumbers.size() < k && nums[i] != i + 1) {
                extraNumbers.add(nums[i]);
                missingNumbers.add(i + 1);
            }
        }

        i = 1;
        while (missingNumbers.size() < k) {
            int candidate = i + nums.length;

            if (!extraNumbers.contains(candidate)) {
                missingNumbers.add(candidate);
            }

            i++;
        }

        return missingNumbers.get(k - 1);
    }
}
