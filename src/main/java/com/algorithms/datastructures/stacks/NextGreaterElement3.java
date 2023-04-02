package com.algorithms.datastructures.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement3 {
    public int[] nextGreaterElements(int[] nums) {
        int[] output = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(output, -1);

        int n = nums.length;
        int i = 2 * (n - 1);

        while (i >= 0) {
            int j = i % n;
            int number = nums[j];

            while (!stack.isEmpty() && stack.peek() <= number) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                output[j] = stack.peek();
            }

            stack.add(number);
            i--;
        }

        return output;
    }
}
