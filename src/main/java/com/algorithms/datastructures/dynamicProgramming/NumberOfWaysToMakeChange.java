package com.algorithms.datastructures.dynamicProgramming;

/**
 * Solution: https://www.algoexpert.io/questions/Number%20Of%20Ways%20To%20Make%20Change
 * Links that helped me to understand it:
 * https://www.youtube.com/watch?v=ZaVM057DuzE&t=482s
 * Recursion solution: https://www.youtube.com/watch?v=k4y5Pr0YVhg
 *
 * Try building an array of the number of ways to make change for all amounts between 0 and n inclusive.
 * Note that there is only one way to make change for 0: that is to not use any coins.
 *
 * Build up the array one coin denomination at a time.
 * In other words, find the number of ways to make change for all amounts between 0 and n with only one denomination,
 * then with two, etc., until you use all denominations.
 *
 * O(nd) time | O(n) space - where n is the target amount and d is the number of coin denominations
 *
 * It is time O(nd) because we are iterating each of the denominations and for each of them, we are then iterating
 * through our array of length n plus one, and for each iteration we're applying the formula in constant time,
 * because we're just checking values that we've previously stored and just doing additions.
 *
 */
public class NumberOfWaysToMakeChange {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] amounts = new int[n+1];

        amounts[0] = 1;

        for (int denom = 0; denom < denoms.length; denom++) {
            for (int amount = 1; amount < amounts.length; amount++) {
                if (denoms[denom] <= amount) {
                    amounts[amount] += amounts[amount - denoms[denom]];
                }
            }
        }
        return amounts[n];
    }
}
