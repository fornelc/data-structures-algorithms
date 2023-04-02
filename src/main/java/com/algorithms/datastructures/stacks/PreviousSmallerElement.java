package com.algorithms.datastructures.stacks;

import java.util.Stack;

public class PreviousSmallerElement {
    public int[] previousSmallerElement(int[] arr) {
        final int[] output = new int[arr.length];
        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];

            while (!stack.isEmpty() && stack.peek() >= number) {
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
