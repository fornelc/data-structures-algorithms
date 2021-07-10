package com.algorithms.datastructures.greedyAlgorithms;

import java.util.Arrays;

public class TandemBicycle {
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        
        if (!fastest) {
            reverseArray(blueShirtSpeeds);
        }

        int result = 0;
        for (int i = 0; i < redShirtSpeeds.length; i++) {
            int redShirtSpeed = redShirtSpeeds[i];
            int blueShirtSpeed = blueShirtSpeeds[blueShirtSpeeds.length - i - 1];
            result += Math.max(redShirtSpeed, blueShirtSpeed);
        }

        return result;
    }

    private void reverseArray(int[] blueShirtSpeeds) {
        int start = 0;
        int end = blueShirtSpeeds.length - 1;
        while(start < end) {
            int temp = blueShirtSpeeds[start];
            blueShirtSpeeds[start] = blueShirtSpeeds[end];
            blueShirtSpeeds[end] = temp;
            start++;
            end--;
        }
    }
}
