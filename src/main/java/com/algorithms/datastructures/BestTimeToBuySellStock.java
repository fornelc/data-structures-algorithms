package com.algorithms.datastructures;

public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int previous = 0;
        for (int a = 0; a < prices.length; a++) {
            for (int b = a + 1; b < prices.length; b++) {
                if (prices[b] > prices[a]) {
                    if (previous < prices[b] - prices[a]) {
                        previous = prices[b] - prices[a];
                    }
                }
            }
        }
        return previous;
    }

    public int maxProfitApproach2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
