package com.algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] currentInterval = sortedIntervals[0];
        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(currentInterval);

        for (int[] nextInterval : sortedIntervals) {
            int endCurrentInterval = currentInterval[1];
            int startNextInterval = nextInterval[0];
            int endNextInterval = nextInterval[1];

            if (endCurrentInterval >= startNextInterval) {
                currentInterval[1] = Math.max(endCurrentInterval, endNextInterval);
            } else {
                currentInterval = nextInterval;
                mergedIntervals.add(currentInterval);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
