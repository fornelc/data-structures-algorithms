package com.algorithms.datastructures.dynamicProgramming;

public class WaterAreaSolution2 {
    public static int waterArea(int[] heights) {
        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        int result = 0;
        int maxLeft = 0;
        int maxRight = 0;
        while (leftPointer < rightPointer) {
            int leftHeight = heights[leftPointer];
            int rightHeight = heights[rightPointer];
            maxLeft = Math.max(maxLeft, leftHeight);
            maxRight = Math.max(maxRight, rightHeight);
            if (maxLeft < maxRight) {
                if (leftHeight < maxLeft) {
                    result += maxLeft - leftHeight;
                }
                leftPointer++;
            } else {
                if (rightHeight < maxRight) {
                    result += maxRight - rightHeight;
                }
                rightPointer--;
            }
        }
        return result;
    }

    public static int waterArea2(int[] heights) {
        int result = 0;
        int leftMax = heights[0];
        int rightMax = heights[heights.length - 1];
        int leftPointer = 0;
        int rightPointer = heights.length - 1;

        while (leftPointer < rightPointer) {
            if (leftMax < rightMax) {
                leftPointer++;
                leftMax = Math.max(leftMax, heights[leftPointer]);
                result += leftMax - heights[leftPointer];
            } else {
                rightPointer--;
                rightMax = Math.max(rightMax, heights[rightPointer]);
                result += rightMax - heights[rightPointer];
            }
        }

        return result;
    }
}
