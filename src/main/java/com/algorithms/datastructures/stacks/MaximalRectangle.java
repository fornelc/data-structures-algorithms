package com.algorithms.datastructures.stacks;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            int area = largestRectangleArea(heights);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int[] nextSmallest = findNextSmallest(heights);
        int[] previousSmallest = findPreviousSmallest(heights);
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int width = nextSmallest[i] - previousSmallest[i] - 1;
            int height = heights[i];

            int area = width * height;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    public int[] findNextSmallest(int[] arr) {
        Stack<int[]> stack = new Stack<>();
        int[] output = new int[arr.length];
        int i = arr.length - 1;

        while (i >= 0) {
            int number = arr[i];

            while (!stack.empty() && stack.peek()[0] >= number) {
                stack.pop();
            }

            if (stack.empty()) {
                output[i] = arr.length;
            } else {
                output[i] = stack.peek()[1];
            }

            stack.push(new int[]{number, i});
            i--;
        }

        return output;
    }

    public int[] findPreviousSmallest(int[] arr) {
        Stack<int[]> stack = new Stack<>();
        int[] output = new int[arr.length];
        int i = 0;

        while (i < arr.length) {
            int number = arr[i];

            while (!stack.empty() && stack.peek()[0] >= number) {
                stack.pop();
            }

            if (stack.empty()) {
                output[i] = -1;
            } else {
                output[i] = stack.peek()[1];
            }

            stack.push(new int[]{number, i});
            i++;
        }

        return output;
    }
}
