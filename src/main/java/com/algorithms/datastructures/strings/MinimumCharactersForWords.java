package com.algorithms.datastructures.strings;

import java.util.*;

/**
 * Write a function that takes in an array of words and returns the smallest
 * array of characters needed to form all of the words. The characters don't need
 * to be in any particular order.
 *
 * O(n * l) time | O(c) space - where n is the number of words, l is the length of the longest word, and c is the number of unique characters across all words.
 */
public class MinimumCharactersForWords {
    public char[] minimumCharactersForWords(String[] words) {
        Map<Character, Integer> maximumCharacterFrequencies = new HashMap<>();
        for (String word : words) {
            Map<Character, Integer> characterFrequencies = countCharacterFrequencies(word);
            updateMaximumFrequencies(characterFrequencies, maximumCharacterFrequencies);
        }
        return makeArrayFromCharacterFrequencies(maximumCharacterFrequencies);
    }

    private Map<Character, Integer> countCharacterFrequencies(String word) {
        Map<Character, Integer> characterFrequencies = new HashMap<>();
        for (char character : word.toCharArray()) {
            characterFrequencies.put(character, characterFrequencies.getOrDefault(character, 0) + 1);
        }
        return characterFrequencies;
    }

    private void updateMaximumFrequencies(Map<Character, Integer> frequencies, Map<Character, Integer> maximumFrequencies) {
        for (Map.Entry<Character, Integer> frequency : frequencies.entrySet()) {
            char character = frequency.getKey();
            int characterFrequency = frequency.getValue();
            if (maximumFrequencies.containsKey(character)) {
                maximumFrequencies.put(character, Math.max(maximumFrequencies.get(character), characterFrequency));
            } else {
                maximumFrequencies.put(character, characterFrequency);
            }
        }
    }

    private char[] makeArrayFromCharacterFrequencies(Map<Character, Integer> maxCharacters) {
        List<Character> characterList = new ArrayList<>();
        for (Map.Entry<Character, Integer> frequency : maxCharacters.entrySet()) {
            char character = frequency.getKey();
            int characterFrequency = frequency.getValue();

            for (int i = 0; i < characterFrequency; i++) {
                characterList.add(character);
            }
        }
        char[] charactersArray = new char[characterList.size()];
        for (int i = 0; i < characterList.size(); i++) {
            charactersArray[i] = characterList.get(i);
        }

        return charactersArray;
    }
}
