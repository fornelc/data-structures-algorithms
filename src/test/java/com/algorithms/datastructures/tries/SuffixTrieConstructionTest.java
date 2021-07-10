package com.algorithms.datastructures.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuffixTrieConstructionTest {
    @Test
    public void TestCase1() {
        var trie = new SuffixTrieConstruction.SuffixTrie("babc");
        assertTrue(trie.contains("abc"));
    }
}
