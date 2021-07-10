package com.algorithms.datastructures.tries;

import java.util.*;

public class SuffixTrieConstruction {
    // Do not edit the class below except for the
    // populateSuffixTrieFrom and contains methods.
    // Feel free to add new properties and methods
    // to the class.
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for (int i = 0; i < str.length(); i++) {
                constructSuffixHelper(i, str);
            }
        }

        private void constructSuffixHelper(int i, String str) {
            TrieNode currentNode = root;
            for (int j = i; j < str.length(); j++) {
                Character letter = str.charAt(j);
                if (!currentNode.children.containsKey(letter)) {
                    TrieNode trieNode = new TrieNode();
                    currentNode.children.put(letter, trieNode);
                }
                currentNode = currentNode.children.get(letter);
            }
            currentNode.children.put(endSymbol, null);
        }

        public boolean contains(String str) {
            TrieNode currentNode = root;
            for (int i = 0; i < str.length(); i++) {
                Character letter = str.charAt(i);
                if (!currentNode.children.containsKey(letter)) {
                    return false;
                }
                currentNode = currentNode.children.get(letter);
            }
            return currentNode.children.containsKey(endSymbol);
        }
    }
}
