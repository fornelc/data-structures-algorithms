package com.algorithms.datastructures.dynamicProgramming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DiskStacking {
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        disks.sort(Comparator.comparing(o -> o[2]));
        int[] heights = new int[disks.size()];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = disks.get(i)[2];
        }
        int[] sequences = new int[disks.size()];
        for (int i = 0; i < sequences.length; i++) {
            sequences[i] = Integer.MIN_VALUE;
        }
        int maximumHeight = 0;
        for (int i = 1; i < disks.size(); i++) {
            Integer[] currentDisk = disks.get(i);
            for (int j = 0; j < i; j++) {
                Integer[] otherDisk = disks.get(j);
                int sumHeights = heights[j] + disks.get(i)[2];
                if (areValidDimensions(otherDisk, currentDisk)) {
                    if (sumHeights > heights[i]) {
                        heights[i] = sumHeights;
                        sequences[i] = j;
                    }
                }
            }
            if (heights[i] > heights[maximumHeight]) {
                maximumHeight = i;
            }
        }
        return buildResult(disks, sequences, maximumHeight);
    }

    private static boolean areValidDimensions(Integer[] o, Integer[] c) {
        return o[0] < c[0] && o[1] < c[1] && o[2] < c[2];
    }

    private static List<Integer[]> buildResult(List<Integer[]> disks, int[] sequences, int currentIdx) {
        List<Integer[]> result = new ArrayList<>();
        while (currentIdx != Integer.MIN_VALUE) {
            result.add(0, disks.get(currentIdx));
            currentIdx = sequences[currentIdx];
        }
        return result;
    }
}
