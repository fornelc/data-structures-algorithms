package com.algorithms.datastructures;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] curr = new int[]{-1, -1};
        int result = 0;
        for (int[] in : intervals) {
            if (in[0] > curr[0] && in[1] > curr[1]) {
                curr[0] = in[0];
                result++;
            }
            curr[1] = Math.max(curr[1], in[1]);
        }
        return result;
    }
}
