package com.algorithms.datastructures.sorting;

public class ThreeNumberSortSolution2 {
    public int[] threeNumberSort(int[] array, int[] order) {
        int firstElement = order[0];
        int thirdElement = order[order.length - 1];

        int firstIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstElement) {
                swap(i, firstIndex, array);
                firstIndex++;
            }
        }

        int thirdIndex = array.length - 1;
        for (int i = thirdIndex; i >= 0; i--) {
            if (array[i] == thirdElement) {
                swap(i, thirdIndex, array);
                thirdIndex--;
            }
        }

        return array;
    }

    private void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
