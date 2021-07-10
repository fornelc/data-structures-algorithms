package com.algorithms.datastructures.sorting;

public class BubbleSort {
    /**
     * Write a function that takes in an array of integers and returns a sorted
     * version of that array. Use the Bubble Sort algorithm to sort the array.
     *
     * Solution: Check if in the array you are doing any swap, in that case we continue the iteration,
     * because that means that it was not sorted yet.
     * As well we set a counter, to avoid looping in our for
     * loop to the end of the array, as in each loop the right most number is itself the biggest number. This doesn't improve
     * the time complexity but makes our algorithm better.
     *
     * Best case scenario : Time O(n) | Space O(1) // If the array doesn't need to be sorted, none swap is done, so it is only iterated once.
     * Average Scenario: Time O(n^2) | Space O(1)
     * Worst case scenario: Time O(n^2) | Space O(1)
     * The space is constant because all of our swaps are done on the input array, we don't allocate additional memory.
     * The time is O n squared, n is the length of the array, and it is squared because we are looping through the
     * array multiple times, we are looping through the array until it gets sorted.
     * @param array
     * @return
     */
    public int[] bubbleSort(int[] array) {
        boolean isSwapped = true;
        int counter = 0;
        while (isSwapped) {
            isSwapped = false;
            for(int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i);
                    isSwapped = true;
                }
            }
            counter++;
        }

        return array;
    }

    private void swap(int[] array, int i) {
        int temp = array[i];
        array[i] = array[i + 1];
        array[i +1] = temp;
    }
}
