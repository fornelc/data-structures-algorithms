package com.algorithms.datastructures.arrays.minRewards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MinRewardsSolution2 {
    public static int minRewards(int[] scores) {
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);
        List<Integer> localValleys = getLocalValleys(scores);

        for (Integer localValley : localValleys) {
            expandLocalValleys(localValley, rewards, scores);
        }

        return IntStream.of(rewards).sum();
    }

    private static List<Integer> getLocalValleys(int[] scores) {
        List<Integer> localValleys = new ArrayList<>();
        if (scores.length == 1) {
            localValleys.add(0);
            return localValleys;
        }

        for (int i = 0; i < scores.length; i++) {
            if (i == 0 && scores[i] < scores[i + 1]) {
                localValleys.add(i);
            } else if (i == scores.length - 1 && scores[i] < scores[i - 1]) {
                localValleys.add(i);
            } else if (i == 0 || i == scores.length - 1) {
                continue;
            } else if (scores[i] < scores[i - 1] && scores[i] < scores[i + 1]) {
                localValleys.add(i);
            }
        }

        return localValleys;
    }

    private static void expandLocalValleys(Integer i, int[] rewards, int[] scores) {
        int leftIndices = i - 1;
        // while idx is greater or equal to zero and we have not reached a peak
        while (leftIndices >= 0 && scores[leftIndices] > scores[leftIndices + 1]) {
            // we make this operation in case that we are overriding a peak
            rewards[leftIndices] = Math.max(rewards[leftIndices], rewards[leftIndices+1] + 1);
            leftIndices--;
        }

        int rightIndices = i + 1;
        // while ids i less than scores length and we have not reached a peak
        while (rightIndices < scores.length && scores[rightIndices - 1] < scores[rightIndices]) {
            rewards[rightIndices] = rewards[rightIndices - 1] + 1;
            rightIndices++;
        }
    }
}
