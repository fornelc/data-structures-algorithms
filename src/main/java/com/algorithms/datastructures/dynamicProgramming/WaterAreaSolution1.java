package com.algorithms.datastructures.dynamicProgramming;

public class WaterAreaSolution1 {
    public static int waterArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int[] leftMax = new int[heights.length];
        for (int i = 1; i < heights.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i - 1]);
        }
        int[] rightMax = new int[heights.length];
        for (int i = heights.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i + 1]);
        }
        int[] water = new int[heights.length];
        int minHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            minHeight = Math.min(leftMax[i], rightMax[i]);
            if (heights[i] < minHeight) {
                water[i] = minHeight - heights[i];
            }
        }

        int result = 0;
        for (int i = 1; i < heights.length; i++) {
            result += water[i];
        }
        return result;
    }

    public static int waterArea2(int[] heights) {
        int[] maxes = new int[heights.length];
        int leftMax = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            maxes[i] = leftMax;
            leftMax = Math.max(leftMax, height);
        }
        int rightMax = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            int height = heights[i];
            int minHeight = Math.min(rightMax, maxes[i]);
            if (height < minHeight) {
                maxes[i] = minHeight - height;
            } else {
                maxes[i] = 0;
            }
            rightMax = Math.max(rightMax, height);
        }
        int total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += maxes[i];
        }
        return total;
    }
}
