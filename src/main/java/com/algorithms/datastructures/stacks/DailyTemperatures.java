package com.algorithms.datastructures.stacks;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        int j = temperatures.length - 1;

        while (j >= 0) {

            int number = temperatures[j];

            while (!stack.isEmpty() && stack.peek()[0] <= number) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                output[j] = 0;
            } else {
                output[j] = stack.peek()[1] - j;
            }

            stack.push(new int[]{number, j});
            j--;
        }

        return output;
    }
}
