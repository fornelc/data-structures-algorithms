package com.algorithms.datastructures.stacks;

import java.util.*;

public class NextGreaterElementAlgoLab {
    public int[] nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] output = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int number = arr[i];

            while (!stack.isEmpty() && stack.peek() <= number) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                output[i] = -1;
            } else {
                output[i] = stack.peek();
            }

            stack.push(number);
        }

        return output;
    }
}
