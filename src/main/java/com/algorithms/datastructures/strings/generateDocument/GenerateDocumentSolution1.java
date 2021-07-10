package com.algorithms.datastructures.strings.generateDocument;

public class GenerateDocumentSolution1 {
    public boolean generateDocument(String characters, String document) {
        for (int i = 0; i < document.length(); i++) {
            int charactersFrequency = getFrequency(document.charAt(i), characters);
            int documentFrequency = getFrequency(document.charAt(i), document);

            if (documentFrequency > charactersFrequency) {
                return false;
            }
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
