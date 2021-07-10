package com.algorithms.datastructures.strings.generateDocument;

import java.util.*;

public class GenerateDocumentSolution3 {
    public boolean generateDocument(String characters, String document) {
        Map<Character, Integer> charactersMap = new HashMap<>();

        for (int i = 0; i < characters.length(); i++) {
            char c = characters.charAt(i);
            charactersMap.put(c, charactersMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < document.length(); i++) {
            char c = document.charAt(i);
            if (!charactersMap.containsKey(c) || charactersMap.get(c) == 0) {
                return false;
            }

            charactersMap.put(c, charactersMap.get(c) - 1);
        }

        return true;
    }
}
