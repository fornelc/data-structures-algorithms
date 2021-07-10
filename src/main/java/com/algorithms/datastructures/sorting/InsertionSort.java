package com.algorithms.datastructures.sorting;

public class InsertionSort {
    /**
     * Write a function that takes in an array of integers and returns a sorted
     * version of that array. Use the Insertion Sort algorithm to sort the array.
     *
     * Average / Worst case scenario Time O(n^2) | Space O(1)
     * Best case scenario Time O(n) | Space O(1)
     *
     * @param array
     * @return
     */
    public int[] insertionSort(int[] array) {
        for (int i = 0; i < array.length; i ++) {
            int j = i;
            while (j > 0 && array[j] < array[j-1]) {
                swap(array, j);
                j-=1;
            }
        }
        return array;
    }

    private void swap(int[] array, int j) {
        int temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;
    }
}
