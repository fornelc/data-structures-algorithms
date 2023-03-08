package com.algorithms.datastructures.codeSignal;

public class ContiguousSawtooth {
    public int countingContiguousSawtooth(int[] arr) {
        int totalSawCounts = 0;
        int previousCount = 0;

        for (int currIdx = 1; currIdx < arr.length; currIdx++) {
            int before = currIdx - 1;
            boolean goingUp;
            if (arr[currIdx] > arr[before]) {
                goingUp = true;
            } else if (arr[currIdx] < arr[before]) {
                goingUp = false;
            } else {
                break;
            }

            int currCount =  1;

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
