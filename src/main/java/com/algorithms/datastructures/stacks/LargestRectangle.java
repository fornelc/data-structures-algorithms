package com.algorithms.datastructures.stacks;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangle {

    public int largestRectangleArea(int[] heights) {
        int[] nextSmaller = findNextSmallest(heights);
        int[] previousSmaller = findPreviousSmallest(heights);

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = nextSmaller[i] - previousSmaller[i] - 1;
            int area = width * heights[i];

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private int[] findNextSmallest(int[] heights) {
        final Stack<int[]> stack = new Stack();
        int[] output = new int[heights.length];
        Arrays.fill(output, heights.length);

        for (int i = heights.length - 1; i >= 0; i--) {
            int number = heights[i];
            while (!stack.isEmpty() && stack.peek()[0] >= number) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                output[i] = stack.peek()[1];
            }

            stack.push(new int[]{number, i});
        }

        return output;
    }

    private int[] findPreviousSmallest(int[] heights) {
        final Stack<int[]> stack = new Stack<>();
        final int[] output = new int[heights.length];
        Arrays.fill(output, -1);

        for (int i = 0; i < heights.length; i++) {
            int number = heights[i];
            while (!stack.isEmpty() && stack.peek()[0] >= number) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                output[i] = stack.peek()[1];
            }

            stack.push(new int[]{number, i});
        }

        return output;
    }
}
