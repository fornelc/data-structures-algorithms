package com.algorithms.datastructures.topKElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binarySearch(arr, x);

        int low = index - k;
        int high = index + k;
        low = Math.max(low, 0);
        high = Math.min(high, arr.length - 1);

        final PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> {
           if (Math.abs(a - x) != Math.abs(b - x)) {
               return Math.abs(a - x) - Math.abs(b - x);
           }

           return a - b;
        });

        for (int i = low; i <= high; i++) {
            minHeap.offer(arr[i]);
        }

        final List<Integer> output = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            output.add(minHeap.poll());
        }

        Collections.sort(output);

        return output;
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left > 0) {
            return left - 1;
        }

        return left;
    }
}
