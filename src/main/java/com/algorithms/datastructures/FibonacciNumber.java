package com.algorithms.datastructures;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumber {

    /**
     * Fibonacci algorithm - Time O(N) | Space O(N)
     * @param n
     * @return
     */
    public int fib(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        if (n == 0 || n == 1) {
            return list.get(n);
        }
        for (int i = 2; i <= n; i++) {
            list.add(list.get(i - 2) + list.get(i - 1));
        }

        return list.get(n);
    }

    /**
     * Fibonacci algorithm - Time O(N) | Space O(1)
     * @param n
     * @return
     */
    public int fibImproved(int n) {
        if (n <= 1) {
            return n;
        }

        int value1 = 0;
        int value2 = 1;

        for (int i = 2; i <= n; i++) {
            int nextValue = value1 + value2;
            value1 = value2;
            value2 = nextValue;
        }

        return value2;
    }
}

// 0, 1, 1, 2, 3, 5, 8, 13