package com.algorithms.datastructures.strings;

public class ReverseWordInStringSolution2 {
    public String reverseWordsInString(String string) {
        char[] characters = string.toCharArray();
        reverseCharRange(characters, 0, characters.length - 1);

        int startOfWord = 0;
        while(startOfWord < string.length()) {
            int endOfWord = startOfWord;

            while (endOfWord < characters.length && characters[endOfWord] != ' ') {
                endOfWord++;
            }

            reverseCharRange(characters, startOfWord, endOfWord - 1);

            startOfWord = endOfWord + 1;
        }


        return new String(characters);
    }

    private void reverseCharRange(char[] characters, int i, int j) {
        int start = i;
        int end = j;
        while (start < end) {
            char temp = characters[start];
            characters[start] = characters[end];
            characters[end] = temp;
            start++;
            end--;
        }
    }
}
