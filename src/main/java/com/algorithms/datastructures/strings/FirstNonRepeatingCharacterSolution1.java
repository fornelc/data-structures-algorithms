package com.algorithms.datastructures.strings;

public class FirstNonRepeatingCharacterSolution1 {
    public int firstNonRepeatingCharacter(String string) {
        for (int i = 0; i < string.length(); i++) {
            boolean repeated = false;
            for (int j = 0; j < string.length(); j++) {
                if (i != j && string.charAt(i) == string.charAt(j)) {
                    repeated = true;
                    break;
                }
            }
            if (!repeated) {
                return i;
            }
        }
        return -1;
    }
}
