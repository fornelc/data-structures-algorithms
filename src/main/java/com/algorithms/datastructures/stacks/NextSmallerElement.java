package com.algorithms.datastructures.stacks;

import java.util.Stack;

public class NextSmallerElement {
    public int[] nextSmallerElement(int[] arr) {
        int[] output = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i++) {
            int number = arr[i];

            while(!stack.isEmpty() && stack.peek() >= number) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                output[i] = -1;
            } else {
                output[i] = stack.peek();
            }

            stack.add(number);
        }

        return output;
    }
}
