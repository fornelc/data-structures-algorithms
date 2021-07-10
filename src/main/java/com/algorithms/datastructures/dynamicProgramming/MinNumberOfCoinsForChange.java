package com.algorithms.datastructures.dynamicProgramming;

import java.util.Arrays;

/**
 * Solution: https://www.algoexpert.io/questions/Min%20Number%20Of%20Coins%20For%20Change
 *
 * Try building an array of the minimum number of coins needed to make change for all amounts between 0 and n inclusive.
 * Note that no coins are needed to make change for 0: in order to make change for 0, you do not need to use any coins.
 *
 * Build up the array one coin denomination at a time.
 * In other words, find the minimum number of coins needed to make change for all amounts between 0 and n
 * with only one denomination, then with two, etc., until you use all denominations.
 *
 * To know if it's impossible to make change for the target amount,
 * say for example we have the target 7 and the denoms 2 and 4.
 * As we initialize our array with MAX_VALUE, we're always gonna have MAX_VALUE set, at number of coins of 7
 * because we couldn't create 7 with 2 and 4, so we will return -1 if the value of amount[n] returns MAX_VALUE.
 *
 * O(nd) time | O(n) space - where n is the target amount and d is the number of coin denominations
 *
 * O(nd) time because we are first iterating through all the denominations
 * and then we are iterating through each of the amounts.
 */
public class MinNumberOfCoinsForChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] amounts = new int[n + 1];
        Arrays.fill(amounts, Integer.MAX_VALUE);
        amounts[0] = 0;
        int toCompare;
        for(int denom : denoms) {
            for( int amount = 0; amount < amounts.length; amount++) {
                if (denom <= amount) {
                    if(amounts[amount - denom] == Integer.MAX_VALUE) {
                        toCompare = amounts[amount - denom];
                    } else {
                        toCompare = 1 + amounts[amount - denom];
                    }
                    amounts[amount] = Math.min(amounts[amount], toCompare);
                }
            }
        }

        return amounts[n] == Integer.MAX_VALUE ? -1 : amounts[n];
    }
}
