package com.algorithms.datastructures.topKElement;

import java.util.*;

public class FrequencySort {
    public int[] frequencySort(int[] nums) {
        final Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        final PriorityQueue<Map.Entry<Integer, Integer>> minMaxHeap =
                new PriorityQueue<>((a, b) -> {
                    if (a.getValue() != b.getValue()) {
                        return a.getValue() - b.getValue();
                    } else {
                        return b.getKey() - a.getKey();
                    }
                });

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minMaxHeap.add(entry);
        }

        List<Integer> output = new ArrayList<>();
        while (!minMaxHeap.isEmpty()) {
            Map.Entry<Integer, Integer> freqNumber = minMaxHeap.poll();
            int num = freqNumber.getKey();
            int frequency = freqNumber.getValue();

            for (int i = 0; i < frequency; i++) {
                output.add(num);
            }
        }

        return output.stream().mapToInt(i -> i).toArray();
    }
}
