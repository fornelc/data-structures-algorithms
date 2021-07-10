package com.algorithms.datastructures.bst;

import java.util.ArrayList;
import java.util.List;

public class FindKthLargestValueInBSTSolution1 {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        List<Integer> nodeValues = new ArrayList<>();
        inOrderTraversalBST(tree, nodeValues);
        return nodeValues.get(nodeValues.size() - k);
    }

    private void inOrderTraversalBST(BST node, List<Integer> nodeValues) {
        if (node == null) {
            return;
        }

        inOrderTraversalBST(node.left, nodeValues);
        nodeValues.add(node.value);
        inOrderTraversalBST(node.right, nodeValues);
    }
}
