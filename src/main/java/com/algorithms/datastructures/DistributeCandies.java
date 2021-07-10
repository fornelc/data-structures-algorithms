package com.algorithms.datastructures;

public class DistributeCandies {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[2];
        for (int i = 0; candies > 0; i++) {
            res[i%2] += Math.min(candies, i + 1);
            candies -= i + 1;
        }
        return res;
    }


}
