package com.algorithms.datastructures.graphs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoggleBoardTest {
    @Test
    public void TestCase1() {
        char[][] board = {
                {'t', 'h', 'i', 's', 'i', 's', 'a'},
                {'s', 'i', 'm', 'p', 'l', 'e', 'x'},
                {'b', 'x', 'x', 'x', 'x', 'e', 'b'},
                {'x', 'o', 'g', 'g', 'l', 'x', 'o'},
                {'x', 'x', 'x', 'D', 'T', 'r', 'a'},
                {'R', 'E', 'P', 'E', 'A', 'd', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'N', 'O', 'T', 'R', 'E', '-', 'P'},
                {'x', 'x', 'D', 'E', 'T', 'A', 'E'},
        };
        String[] words = {
                "this", "is", "not", "a", "simple", "boggle", "board", "test", "REPEATED", "NOTRE-PEATED"
        };
        String[] expected = {"this", "is", "a", "simple", "boggle", "board", "NOTRE-PEATED"};
        List<String> actual = BoggleBoard.boggleBoard(board, words);
        assertTrue(actual.size() == expected.length);
        for (String word : actual) {
            assertTrue(contains(expected, word));
        }
    }

    @Test
    public void TestCase2() {
        char[][] board = {
                {'y', 'g', 'f', 'y', 'e', 'i'},
                {'c', 'o', 'r', 'p', 'o', 'u'},
                {'j', 'u', 'z', 's', 'e', 'l'},
                {'s', 'y', 'u', 'r', 'h', 'p'},
                {'e', 'a', 'e', 'g', 'n', 'd'},
                {'h', 'e', 'l', 's', 'a', 't'},
        };
        String[] words = {
                "san", "sana", "at", "vomit", "yours", "help", "end", "been", "bed", "danger", "calm", "ok", "chaos", "complete", "rear", "going", "storm", "face", "epual", "dangerous"
        };
        String[] expected = {"at", "danger", "help", "san", "yours"};
        List<String> actual = BoggleBoard.boggleBoard(board, words);
        assertTrue(actual.size() == expected.length);
        for (String word : actual) {
            assertTrue(contains(expected, word));
        }
    }

    @Test
    public void TestCase4() {
        char[][] board = {
                {'a', 'b'},
                {'c', 'd'},
        };
        String[] words = {
                "abcd", "abdc", "acbd", "acdb", "adbc", "adcb", "abca"
        };
        String[] expected = {"abcd", "abdc", "acbd", "acdb", "adbc", "adcb"};
        List<String> actual = BoggleBoard.boggleBoard(board, words);
        assertTrue(actual.size() == expected.length);
        for (String word : actual) {
            assertTrue(contains(expected, word));
        }
    }

    public static boolean contains(String[] wordArray, String targetWord) {
        for (String word : wordArray) {
            if (targetWord.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
