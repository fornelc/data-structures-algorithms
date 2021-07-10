package com.algorithms.datastructures.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Source: https://www.algoexpert.io/questions/Reverse%20Words%20In%20String
 */
public class ReverseWordInStringSolution1 {
    public String reverseWordsInString(String string) {
        List<String> words = new ArrayList<>();
        int startOfWord = 0;

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character == ' ') {
                words.add(string.substring(startOfWord, i));
                startOfWord = i;
            } else if (string.charAt(startOfWord) == ' ') {
                words.add(string.substring(startOfWord, i));
                startOfWord = i;
            }
        }

        words.add(string.substring(startOfWord));

        reverseList(words);

        return String.join("", words);
    }

    private void reverseList(final List<String> words) {
        int start = 0;
        int end = words.size() - 1;
        while (start < end) {
            String temp = words.get(start);
            words.set(start, words.get(end));
            words.set(end, temp);
            start++;
            end--;
        }
    }
}
