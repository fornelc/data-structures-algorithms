package com.algorithms.datastructures.topKElement;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencysortString {
    public String frequencySort(String s) {
        final Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            final Character character = s.charAt(i);
            freq.put(character, freq.getOrDefault(character, 0) + 1);
        }

        final PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            maxHeap.add(entry);
        }

        final StringBuilder output = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            Character character = entry.getKey();
            int value = entry.getValue();

            for (int i = 0; i < value; i++) {
                output.append(character);
            }
        }

        return output.toString();
    }
}
