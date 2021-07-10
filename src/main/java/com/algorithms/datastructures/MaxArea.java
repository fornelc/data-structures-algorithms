package com.algorithms.datastructures;

public class MaxArea {
    /**
     * We will simply consider the area for every possible pair of the lines
     * and find out the maximum area out of those.
     * @param height
     * @return
     */
    public int maxAreaBruteForce(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }

    /**
     * Initially we consider the area constituting the exterior most lines.
     * Now, to maximize the area, we need to consider the area between the lines of larger lengths.
     * If we try to move the pointer at the longer line inwards, we won't gain any increase in area,
     * since it is limited by the shorter line. But moving the shorter line's pointer could turn out to be beneficial,
     * as per the same argument, despite the reduction in the width.
     * This is done since a relatively longer line obtained by moving the shorter line's pointer might overcome
     * the reduction in area caused by the width reduction.
     * @param height
     * @return
     */
    public int maxAreaTwoPointerApproach(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
