package com.algorithms.datastructures.dynamicProgramming;

import java.util.*;

public class NumbersInPi {
    public static int numbersInPi(String pi, String[] numbers) {
        Set<String> numbersTable = new HashSet<>();
        for (String number : numbers) {
            numbersTable.add(number);
        }
        Map<Integer, Integer> cache = new HashMap<>();
        int minSpaces = getMinNumberOfSpaces(pi, numbersTable, cache, 0);
        return minSpaces == Integer.MAX_VALUE ? -1 : minSpaces;
    }

    private static int getMinNumberOfSpaces(String pi, Set<String> numbersTable, Map<Integer, Integer> cache, int idx) {
        if (idx == pi.length()) {
            return -1;
        }
        if (cache.containsKey(idx)) {
            return cache.get(idx);
        }
        int minSpace = Integer.MAX_VALUE;
        for (int i = idx; i < pi.length(); i++) {
            String suffix = pi.substring(idx, i + 1);
            if (numbersTable.contains(suffix)) {
                int minSuffixSpace = getMinNumberOfSpaces(pi, numbersTable, cache, i + 1);
                if (minSuffixSpace == Integer.MAX_VALUE) {
                    minSpace = Math.min(minSpace, minSuffixSpace);
                } else {
                    minSpace = Math.min(minSpace, minSuffixSpace + 1);
                }
            }
        }
        cache.put(idx, minSpace);
        return cache.get(idx);
    }
}
