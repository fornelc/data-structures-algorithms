package com.algorithms.datastructures.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Source: https://www.algoexpert.io/questions/Staircase%20Traversal
 * Explanation in Bitbucket document.
 */
public class PhoneNumberMnemonics {

    private static Map<Character, String[]> PAD_NUMBERS = new HashMap<>();

    static {
        PAD_NUMBERS.put('0', new String[] {"0"});
        PAD_NUMBERS.put('1', new String[] {"1"});
        PAD_NUMBERS.put('2', new String[] {"a", "b", "c"});
        PAD_NUMBERS.put('3', new String[] {"d", "e", "f"});
        PAD_NUMBERS.put('4', new String[] {"g", "h", "i"});
        PAD_NUMBERS.put('5', new String[] {"j", "k", "l"});
        PAD_NUMBERS.put('6', new String[] {"m", "n", "o"});
        PAD_NUMBERS.put('7', new String[] {"p", "q", "r", "s"});
        PAD_NUMBERS.put('8', new String[] {"t", "u", "v"});
        PAD_NUMBERS.put('9', new String[] {"w", "x", "y", "z"});
    }

    public List<String> phoneNumberMnemonics(String phoneNumber) {
        List<String> mnemonics = new ArrayList<>();
        helper(phoneNumber, mnemonics, 0, new String[phoneNumber.length()]);
        return mnemonics;
    }

    private void helper(String phoneNumber, List<String> mnemonics, int index, String[] mnemonic) {
        if (index == phoneNumber.length()) {
            String stringMnemonic = String.join("", mnemonic);
            mnemonics.add(stringMnemonic);
            return;
        }
        Character number = phoneNumber.charAt(index);
        String[] characters = PAD_NUMBERS.get(number);
        for (String character : characters) {
            mnemonic[index] = character;
            helper(phoneNumber, mnemonics, index + 1, mnemonic);
        }
    }
}
