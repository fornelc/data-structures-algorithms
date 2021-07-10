package com.algorithms.datastructures.bst;

import java.util.List;

public class SameBSTsSolution2 {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        return sameBstsHelper(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean sameBstsHelper(List<Integer> arrayOne, List<Integer> arrayTwo,
                                          int idxOne, int idxTwo, int minValue, int maxValue) {
        if (idxOne == -1 || idxTwo == -1) {
            return idxOne == idxTwo;
        }

        if (arrayOne.get(idxOne) != arrayTwo.get(idxTwo)) {
            return false;
        }

        int leftIdxOne = getIdxOfFirstSmaller(arrayOne, idxOne, minValue);
        int leftIdxTwo = getIdxOfFirstSmaller(arrayTwo, idxTwo, minValue);
        int rightIdxOne = getIdxOfFirstBiggerOrEqual(arrayOne, idxOne, maxValue);
        int rightIdxTwo = getIdxOfFirstBiggerOrEqual(arrayTwo, idxTwo, maxValue);

        int currentValue = arrayOne.get(idxOne);

        boolean sameLeft = sameBstsHelper(arrayOne, arrayTwo, leftIdxOne, leftIdxTwo, minValue, currentValue);
        boolean sameRight = sameBstsHelper(arrayOne, arrayTwo, rightIdxOne, rightIdxTwo, currentValue, maxValue);

        return sameLeft && sameRight;
    }

    private static int getIdxOfFirstSmaller(List<Integer> array, int startingIdx, int minValue) {
        // Find the index of the first smaller value after the startingIdx.
        // Make sure that this value is greater than or equal to the minVal,
        // which is the value of the previous parent node in the BST.
        // If it isn't, then that value is located in the left subtree of the
        // previous parent node.
        for (int i = startingIdx + 1; i < array.size(); i++) {
            if (array.get(i) < array.get(startingIdx) &&
                    array.get(i) >= minValue) {
                return i;
            }
        }

        return -1;
    }

    private static int getIdxOfFirstBiggerOrEqual(List<Integer> array, int startingIdx, int maxValue) {
        // Find the index of the first bigger/equal value after the startingIdx.
        // Make sure that this value is smaller than maxVal, which is the value
        // of the previous parent node in the BST. If it isn't, then that value
        // is located in the right subtree of the previous parent node.
        for (int i = startingIdx + 1; i < array.size(); i++) {
            if (array.get(i) >= array.get(startingIdx) &&
                    array.get(i) < maxValue) {
                return i;
            }
        }

        return -1;
    }
}