package com.algorithms.datastructures.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MinimumCharactersForWordsTest {
    @Test
    public void TestCase1() {
        String[] words = new String[] {"this", "that", "did", "deed", "them!", "a"};
        char[] expected = new char[] {'t', 't', 'h', 'i', 's', 'a', 'd', 'd', 'e', 'e', 'm', '!'};
        var actual = new MinimumCharactersForWords().minimumCharactersForWords(words);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}
