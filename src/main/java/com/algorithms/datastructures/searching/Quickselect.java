package com.algorithms.datastructures.searching;

/**
 * Function that takes in an array of distinct integers as well as an integer k and that returns
 * the kth smallest integer in that array.
 *
 * The function do this in linear time on average.
 */
public class Quickselect {
  public static int quickselect(int[] array, int k) {
    return quickselectHelper(array, 0, array.length - 1, k - 1);
  }

  private static int quickselectHelper(int[] array, int startIdx, int endIdx, int position) {
    while(true) {
      int pivotIdx = startIdx;
      int leftIdx = startIdx + 1;
      int rightIdx = endIdx;
      while (rightIdx >= leftIdx) {
        if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
          swap(array, leftIdx, rightIdx);
        }
        if (array[leftIdx] <= array[pivotIdx]) {
          leftIdx++;
        }
        if (array[rightIdx] >= array[pivotIdx]) {
          rightIdx--;
        }
      }
      swap(array, pivotIdx, rightIdx);
      if (rightIdx == position) {
        return array[rightIdx];
      }
      if (rightIdx < position) {
        startIdx = rightIdx + 1;
      } else {
        endIdx = rightIdx - 1;
      }
    }
  }

  private static void swap(int[] array, int leftIdx, int rightIdx) {
    int aux = array[leftIdx];
    array[leftIdx] = array[rightIdx];
    array[rightIdx] = aux;
  }
}
