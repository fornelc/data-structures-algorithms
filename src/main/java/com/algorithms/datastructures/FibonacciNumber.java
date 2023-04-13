package com.algorithms.datastructures;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumber {
    // Time O(N) | Space O(N)
    public int fib(int N) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        if (N == 0 || N == 1) {
            return list.get(N);
        }
        for (int i = 2; i <= N; i++) {
            list.add(list.get(i - 2) + list.get(i - 1));
        }

        return list.get(N);
    }

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