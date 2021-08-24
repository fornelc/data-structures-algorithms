package com.algorithms.datastructures.graphs;

import java.util.*;

public class BoggleBoard {
    public static List<String> boggleBoard(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }

        Set<String> finalWords = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length; j++) {
                explore(i, j, board, finalWords, visited, trie.root);
            }
        }

        return new ArrayList<>(finalWords);
    }

    private static void explore(int i,
                                int j,
                                char[][] board,
                                Set<String> finalWords,
                                boolean[][] visited,
                                TrieNode node) {
        if (visited[i][j]) {
            return;
        }
        Character letter = board[i][j];
        if (!node.children.containsKey(letter)) {
            return;
        }
        visited[i][j] = true;
        node = node.children.get(letter);
        if (node.children.containsKey('*')) {
            finalWords.add(node.word);
        }
        List<Integer[]> neighbors = getNeighbors(i, j, board);
        for (Integer[] neighbor : neighbors) {
            explore(neighbor[0], neighbor[1], board, finalWords, visited, node);
        }
        visited[i][j] = false;
    }

    private static List<Integer[]> getNeighbors(int i, int j, char[][] board) {
        List<Integer[]> neighbors = new ArrayList<>();

        if (i > 0 && j > 0) {
            neighbors.add(new Integer[]{i - 1, j - 1});
        }
        if (i > 0) {
            neighbors.add(new Integer[]{i - 1, j});
        }
        if (i > 0 && j < board[0].length - 1) {
            neighbors.add(new Integer[]{i - 1, j + 1});
        }
        if (j > 0) {
            neighbors.add(new Integer[]{i, j - 1});
        }
        if (j < board[0].length - 1) {
            neighbors.add(new Integer[]{i, j + 1});
        }
        if (i < board.length - 1 && j < board[0].length - 1) {
            neighbors.add(new Integer[]{i + 1, j + 1});
        }
        if (i < board.length - 1) {
            neighbors.add(new Integer[]{i + 1, j});
        }
        if (i <board.length - 1 && j > 0) {
            neighbors.add(new Integer[]{i + 1, j - 1});
        }
        return neighbors;
    }

    public static class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public String word = "";
    }

    public static class Trie {
        public TrieNode root;
        public Character endSymbol;

        public Trie() {
            root = new TrieNode();
            endSymbol = '*';
        }

        public void add(final String word) {
            TrieNode node = this.root;
            for (int i = 0; i < word.length(); i++) {
                Character letter = word.charAt(i);
                if (!node.children.containsKey(letter)) {
                    node.children.put(letter, new TrieNode());
                }
                node = node.children.get(letter);
            }
            node.children.put(this.endSymbol, null);
            node.word = word;
        }
    }
}
