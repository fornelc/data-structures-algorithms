package com.algorithms.datastructures.arrays.sortedSquaredArray;

public class SortedSquaredArraySolution2 {
    public int[] sortedSquaredArray(int[] array) {
        int[] sortedSquares = new int[array.length];
        int smallerPointer = 0;
        int largerPointer = array.length - 1;

        for(int i = array.length - 1; i >= 0; i--) {
            int smallerValue = array[smallerPointer];
            int largerValue = array[largerPointer];
            if (Math.abs(smallerValue) > Math.abs(largerValue)) {
                sortedSquares[i] = smallerValue * smallerValue;
                smallerPointer++;
            } else {
                sortedSquares[i] = largerValue * largerValue;
                largerPointer--;
            }
        }

        return sortedSquares;
    }
}
