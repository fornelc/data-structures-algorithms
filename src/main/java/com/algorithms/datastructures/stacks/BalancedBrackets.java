package com.algorithms.datastructures.stacks;

import java.util.*;

public class BalancedBrackets {
    final private static String openingBrackets = "([{";
    final private static String closingBrackets = ")]}";
    final private static Map<Character, Character> bracketsMap = new HashMap<>();

    static {
        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');
        bracketsMap.put('}', '{');
    }
    public static boolean balancedBrackets(String str) {
        List<Character> stack = new ArrayList<>();
        for (int character = 0; character < str.length(); character++){
            if (openingBrackets.indexOf(str.charAt(character)) != -1) {
                stack.add(str.charAt(character));
            } else if (closingBrackets.indexOf(str.charAt(character)) != -1) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character lastCharacter = stack.get(stack.size() - 1);
                    Character currentCharacter = str.charAt(character);
                    if (bracketsMap.get(currentCharacter) != lastCharacter) {
                        return false;
                    } else {
                        stack.remove(stack.size() - 1);
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
