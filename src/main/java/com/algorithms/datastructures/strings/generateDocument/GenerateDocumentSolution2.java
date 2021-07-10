package com.algorithms.datastructures.strings.generateDocument;

import java.util.HashSet;
import java.util.Set;

public class GenerateDocumentSolution2 {
    public boolean generateDocument(String characters, String document) {
        Set<Character> charAlreadyVisited = new HashSet<>();
        for (int i = 0; i < document.length(); i++) {
            char character = document.charAt(i);

            if (charAlreadyVisited.contains(character)) {
                continue;
            }

            int charactersFrequency = getFrequency(document.charAt(i), characters);
            int documentFrequency = getFrequency(document.charAt(i), document);

            if (documentFrequency > charactersFrequency) {
                return false;
            }

            charAlreadyVisited.add(character);
        }

        return true;
    }

    private int getFrequency(char character, String target) {
        int frequency = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (c == character) {
                frequency++;
            }
        }

        return frequency;
    }
}
