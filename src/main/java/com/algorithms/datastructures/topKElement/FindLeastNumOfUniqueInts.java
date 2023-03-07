package com.algorithms.datastructures.topKElement;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindLeastNumOfUniqueInts {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        final Map<Integer, Integer> freq = new HashMap<>();

        for (int number : arr) {
            freq.put(number, freq.getOrDefault(number, 0) + 1);
        }

        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]).reversed());

        for (Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            minHeap.offer(new int[] {entry.getValue(), entry.getKey()});
        }

        while (k > 0) {
            int[] pair = minHeap.poll();
            int frequency = pair[0];
            int element = pair[1];

            frequency--;

            if (frequency > 0) {
                minHeap.offer(new int[]{frequency, element});
            }

            k--;
        }

        return minHeap.size();
    }
}
