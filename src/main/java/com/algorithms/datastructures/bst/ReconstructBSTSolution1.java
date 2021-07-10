package com.algorithms.datastructures.bst;

import java.util.List;

public class ReconstructBSTSolution1 {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues.isEmpty()) {
            return null;
        }

        int currentValue = preOrderTraversalValues.get(0);
        int rightChildIdx = preOrderTraversalValues.size();

        for (int i = 1; i < preOrderTraversalValues.size(); i++) {
            int value = preOrderTraversalValues.get(i);
            if (value >= currentValue) {
                rightChildIdx = i;
                break;
            }
        }

        // The sublist method has a time complexity of O(n),
        // but in terms of time complexity, the overall time complexity of the algorithm
        // is still O(n)
        BST leftChild = reconstructBst(preOrderTraversalValues.subList(1, rightChildIdx));
        BST rightChild = reconstructBst(preOrderTraversalValues.subList(rightChildIdx, preOrderTraversalValues.size()));

        BST result = new BST(currentValue);
        result.left = leftChild;
        result.right = rightChild;

        return result;
    }
}
