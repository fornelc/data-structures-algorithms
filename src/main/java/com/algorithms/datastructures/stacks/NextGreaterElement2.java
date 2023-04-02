package com.algorithms.datastructures.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final Map<Integer, Integer> dictIndexNums1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int num1 = nums1[i];
            dictIndexNums1.put(num1, i);
        }

        final Stack<Integer> stack = new Stack<>();
        final int[] output = new int[nums1.length];
        Arrays.fill(output, -1);
        for (int i = nums2.length - 1; i >= 0; i--) {
            int number = nums2[i];
            if (dictIndexNums1.containsKey(number)) {
                while (!stack.isEmpty() && stack.peek() <= number) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int indexNum1 = dictIndexNums1.get(number);
                    output[indexNum1] = stack.peek();
                }
            }

            stack.add(number);
        }

        return output;
    }
}
