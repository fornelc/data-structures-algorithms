package com.algorithms.datastructures.sorting;

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
