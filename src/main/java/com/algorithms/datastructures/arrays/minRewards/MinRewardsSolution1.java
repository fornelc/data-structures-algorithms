package com.algorithms.datastructures.arrays.minRewards;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinRewardsSolution1 {
    public static int minRewards(int[] scores) {
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);

        for (int i = 1; i < scores.length; i++) {
            int j = i-1;

            if (scores[i] > scores[j]) {
                rewards[i] = rewards[j] + 1;
            } else {
                while (j >= 0 && scores[j] > scores[j+1]) {
                    rewards[j] = Math.max(rewards[j], rewards[j+1] + 1);
                    j--;
                }
            }
        }

        return IntStream.of(rewards).sum();
    }
}
