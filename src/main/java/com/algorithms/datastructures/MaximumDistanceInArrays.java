package com.algorithms.datastructures;

import java.util.List;

public class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = 0;
        int start = arrays.get(0).get(0);
        int end = arrays.get(0).get(arrays.get(0).size() - 1);

        for (List<Integer> nums : arrays.subList(1, arrays.size())) {
            result = Math.max(result,
                    Math.max(
                            Math.abs(nums.get(nums.size() - 1) - start),
                            Math.abs(end - nums.get(0))));
            start = Math.min(start, nums.get(0));
            end = Math.max(end, nums.get(nums.size() - 1));
        }

        return result;
    }
}
