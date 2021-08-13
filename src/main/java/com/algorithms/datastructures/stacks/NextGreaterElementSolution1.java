package com.algorithms.datastructures.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * Write a function that takes in an array of integers and returns a new array
 * containing, at each index, the next element in the input array that's greater
 * than the element at that index in the input array.
 *
 * O(n) time | O(n) space - where n is the length of the array
 */
public class NextGreaterElementSolution1 {
    public int[] nextGreaterElement(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * array.length; i++) {
            int currentIdx = i % array.length;

            while (stack.size() > 0 && array[stack.peek()] < array[currentIdx]) {
                int top = stack.pop();
                result[top] = array[currentIdx];
            }

            stack.push(currentIdx);
        }

        return result;
    }
}
