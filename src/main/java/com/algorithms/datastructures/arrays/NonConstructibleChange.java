package com.algorithms.datastructures.arrays;

import java.util.Arrays;

public class NonConstructibleChange {
    public int nonConstructibleChange(int[] coins) {
        int minimumCurrentChange = 0;

        Arrays.sort(coins);
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > minimumCurrentChange + 1) {
                return minimumCurrentChange + 1;
            }
            minimumCurrentChange += coins[i];
        }

        return minimumCurrentChange + 1;
    }
}
