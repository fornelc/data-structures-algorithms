package com.algorithms.datastructures.strings;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterSolution2 {
    public int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> charactersMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            charactersMap.put(c, charactersMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (charactersMap.get(c) == 1) {
                return i;
            }
        }

        return -1;
    }
}
