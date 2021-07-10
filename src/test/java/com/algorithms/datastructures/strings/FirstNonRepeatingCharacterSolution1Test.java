package com.algorithms.datastructures.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstNonRepeatingCharacterSolution1Test{
    @Test
    public void TestCase1() {
        String input = "abcdcaf";
        int expected = 1;
        var actual = new FirstNonRepeatingCharacterSolution1().firstNonRepeatingCharacter(input);
        assertTrue(expected == actual);
    }
}
