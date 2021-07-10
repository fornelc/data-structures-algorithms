package com.algorithms.datastructures.strings;

public class CaesarCypherEncryptor {
    /**
     * https://www.algoexpert.io/questions/Caesar%20Cipher%20Encryptor
     *
     * Given a non-empty string of lowercase letters and a non-negative integer
     * representing a key, write a function that returns a new string obtained by
     * shifting every letter in the input string by k positions in the alphabet,
     * where k is the key.
     *
     * Note that letters should "wrap" around the alphabet; in other words, the
     * letter.
     *
     * Sample Input:
     * string = "xyz"
     * key = 2
     *
     * Sample Output: "zab"
     *
     * Notes: This exercise tests your understanding of the modulo operator.
     * By getting the mod of 25 we don't end up in these tricky situations
     * where we have a number that even mod 122 when it is added to 96 is
     * greater than 122, and is outside of our alphabet size.
     *
     * Time O(n) | Space O(n)
     */
    public static String caesarCypherEncryptor(String str, int key) {
        int alphabetMod = key % 26;
        char[] chars = new char[str.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = helper(str.charAt(i), alphabetMod);
        }
        return new String(chars);
    }

    private static char helper(int character, int alphabetMod) {
        int newChar = character + alphabetMod;
        return newChar <= 122 ? (char) newChar : (char) (96 + (newChar % 122));
    }

    public static String caesarCypherEncryptorUsingAlphabet(String str, int key) {
        int alphabetMod = key % 26;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = new char[str.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = helperAlphabet(str.charAt(i), alphabet, alphabetMod);
        }
        return new String(chars);
    }

    private static char helperAlphabet(int character, String alphabet, int alphabetMod) {
        int newLetterCode = alphabet.indexOf(character) + alphabetMod;
        return alphabet.charAt(newLetterCode % 26);
    }
}
