package com.algorithms.datastructures.sorting;

public class SelectionSort {
    /**
     * Write a function that takes in an array of integers and returns a sorted
     * version of that array. Use the Selection Sort algorithm to sort the array.
     *
     * Sample Input = [8, 5, 2, 9, 5, 6, 3]
     * Sample Output = [2, 3, 5, 5, 6, 8, 9]
     *
     * Space O(1) | Time O(n^2)
     * Time is O n square because we kept iterating through an unsorted sublist
     * which kept having a length reduced by one at every iteration, and we are going
     * to use two loops. This sort algorithm is not as good as quick sort, heap sort
     * or merge sort, but it is easy to implement and understand.
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int smallest = i;
            for (int j = i; j < array.length; j++) {
                if (array[smallest] > array[j]) {
                    smallest = j;
                }
            }
            swap(array, i, smallest);
        }
        return array;
    }

    private static void swap(int[] array, int i, int smallest) {
        int temp = array[i];
        array[i] = array[smallest];
        array[smallest] = temp;
    }
}
