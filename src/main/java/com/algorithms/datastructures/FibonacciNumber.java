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
}

// 0, 1, 1, 2, 3, 5, 8, 13