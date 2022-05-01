package com.algorithms.datastructures.sorting;

/**
 * The worst case scenario is gonna be O(n^2) time, this is gonna happen when each time that you cut in half your array,
 * the smaller subArray has a length of one, and the other side is going to contain the rest of elements of the array,
 * so you are going to end iterating the left and right pointers n^2 times.
 *
 * The average and the best are going to be O(nlog(n)), because in average we will be cutting the input in half,
 * and we will be doing each time O(log(n)) time operations before you reach sub arrays of length one.
 *
 * Space complexity O(log(n)), as we will be sorting first the smaller subArray,
 * the smaller subArray is going to raise a stack frame of O(log(n)) space.
 * When afterwards we start to sort the bigger subArray,
 * it will be sort using tail recursion which doesn't add to the call stack,
 * keeping the stack bounded to O(log(n))
 */
public class QuickSort {
    public static int[] quickSort(int[] array) {
        quickSortHelper(0, array.length - 1, array);
        return array;
    }

    private static void quickSortHelper(int startIdx, int endIdx, int[] array) {
        if (startIdx >= endIdx) {
            return;
        }
        int pivot = array[startIdx];
        int leftPointer = startIdx + 1;
        int rightPointer = endIdx;
        while (rightPointer >= leftPointer) {
            if (array[leftPointer] > pivot && array[rightPointer] < pivot) {
                swap(leftPointer, rightPointer, array);
            }
            if (array[leftPointer] <= pivot) {
                leftPointer++;
            }
            if (array[rightPointer] >= pivot) {
                rightPointer--;
            }
        }
        swap(startIdx, rightPointer, array);
        boolean isLeftSubarraySmaller = rightPointer - 1 - startIdx < endIdx - (rightPointer + 1);
        if (isLeftSubarraySmaller) {
            quickSortHelper(startIdx, rightPointer - 1, array);
            quickSortHelper(rightPointer + 1, endIdx, array);
        } else {
            quickSortHelper(rightPointer + 1, endIdx, array);
            quickSortHelper(startIdx, rightPointer - 1, array);
        }
    }

    private static void swap(int leftPointer, int rightPointer, int[] array) {
        int aux = array[leftPointer];
        array[leftPointer] = array[rightPointer];
        array[rightPointer] = aux;
    }
}
