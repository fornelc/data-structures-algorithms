package com.algorithms.datastructures.strings;

import java.util.*;

/**
 * Source: https://www.algoexpert.io/questions/Group%20Anagrams
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> mapStrings = new HashMap<>();
        for (String word : words) {
            char[] characters = word.toCharArray();
            Arrays.sort(characters);
            String sortedString = new String(characters);

            if (mapStrings.containsKey(sortedString)) {
                mapStrings.get(sortedString).add(word);
            } else {
                mapStrings.put(sortedString, new ArrayList(Arrays.asList(word)));
            }

        }
        return new ArrayList(mapStrings.values());
    }
}
