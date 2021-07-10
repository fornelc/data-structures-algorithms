package com.algorithms.datastructures.sorting;

public class ThreeNumberSortSolution3 {
    public int[] threeNumberSort(int[] array, int[] order) {
        int firstPointer = 0;
        int secondPointer = 0;
        int thirdPointer = array.length - 1;

        while (secondPointer <= thirdPointer) {
            int secondPointerValue = array[secondPointer];
            if (secondPointerValue == order[0]) {
                swap(firstPointer, secondPointer, array);
                firstPointer++;
                secondPointer++;
            } else if (secondPointerValue == order[1]) {
                secondPointer++;
            } else {
                swap(secondPointer, thirdPointer, array);
                thirdPointer--;
            }
        }

        return array;
    }

    private void swap(int j, int i, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
