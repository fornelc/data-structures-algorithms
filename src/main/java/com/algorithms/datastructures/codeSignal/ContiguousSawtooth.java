package com.algorithms.datastructures.codeSignal;

public class ContiguousSawtooth {
    public int countingContiguousSawtooth(int[] arr) {
        // holds the count of sawtooths at each index of our input array,
        // for sawtooth lengths up to that index
        int[] saws = new int[arr.length];
        // the resulting total sawtooth counts
        int totalSawCounts = 0;
        int previousCount = 0;

        for (int currIdx = 1; currIdx < arr.length; currIdx++) {
            int currCount = 0;
            int before = currIdx - 1;
            boolean goingUp;
            if (arr[currIdx] > arr[before]) {
                goingUp = true;
            } else if (arr[currIdx] < arr[before]) {
                goingUp = false;
            } else {
                break;
            }

            // if we made it here, we have at least one sawtooth
            currCount =  1;

            // see if there was a previous solution (the DP part)
            // and if it continues our current sawtooth
            if (before >= 1) {
                if (goingUp) {
                    if (arr[before-1] > arr[before]) {
                        currCount = previousCount + currCount;
                    }
                } else {
                    if (arr[before-1] < arr[before]) {
                        currCount = previousCount + currCount;
                    }
                }
            }
            previousCount = currCount;
            totalSawCounts = totalSawCounts + currCount;
        }

        return totalSawCounts;
    }
}
