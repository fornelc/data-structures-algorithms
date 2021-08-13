package com.algorithms.datastructures.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * Write a function that takes in an array of integers and returns a new array
 * containing, at each index, the next element in the input array that's greater
 * than the element at that index in the input array.
 *
 * In this solution I'm looping from right to left and adding the value of elements on the stack rather than their indices
 *
 * O(n) time | O(n) space - where n is the length of the array
 */
public class NextGreaterElementSolution2 {
    public int[] nextGreaterElement(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = (2 * array.length) - 1; i >= 0; i--) {
            int currentIdx = i % array.length;

            while(stack.size() > 0) {
                if (stack.peek() > array[currentIdx]) {
                    result[currentIdx] = stack.peek();
                    break;
                } else {
                    stack.pop();
                }
            }
            stack.push(array[currentIdx]);
        }

        return result;
    }
}
