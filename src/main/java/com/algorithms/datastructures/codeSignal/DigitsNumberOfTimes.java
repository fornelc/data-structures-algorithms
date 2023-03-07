package com.algorithms.datastructures.codeSignal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DigitsNumberOfTimes {

    int[] solution(int[] a) {
        final Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;

        for (int number : a) {
            while (number > 0) {
                int digit = number % 10;
                freq.put(digit, freq.getOrDefault(digit, 0) + 1);
                int frequency = freq.get(digit);
                maxFreq = Math.max(frequency, maxFreq);

                number /= 10;
            }
        }

        final List<Integer> output = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            final int digit = entry.getKey();
            final int frequency = entry.getValue();

            if (frequency == maxFreq) {
                output.add(digit);
            }
        }

        return output.stream().mapToInt(i -> i).toArray();
    }

}
