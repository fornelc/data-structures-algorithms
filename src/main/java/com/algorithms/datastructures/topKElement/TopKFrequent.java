package com.algorithms.datastructures.topKElement;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i] + 1, 0));
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> item : freq.entrySet()) {
            minHeap.offer(item);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] output = new int[k];
        int i = 0;

        while (!minHeap.isEmpty()) {
            output[i] = minHeap.poll().getKey();
            i++;
        }

        return output;
    }
}
