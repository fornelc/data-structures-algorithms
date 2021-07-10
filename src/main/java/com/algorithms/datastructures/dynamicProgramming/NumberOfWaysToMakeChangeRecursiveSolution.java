package com.algorithms.datastructures.dynamicProgramming;

/**
 * Time complexity O(nm) n is the amount and m is the number of coins
 */
public class NumberOfWaysToMakeChangeRecursiveSolution {
    public int[] coins = {1, 2, 5};

    public int counter = 0;

    public int combo(int amount, int currentCoin) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 ) {
            return 0;
        }

        int nCombos = 0;

        for (int coin = currentCoin; coin < coins.length; coin++) {
            System.out.println(++counter);
            nCombos = nCombos + combo(amount - coins[coin], coin);
        }
        return nCombos;
    }
}
