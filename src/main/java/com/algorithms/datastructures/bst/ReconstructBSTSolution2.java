package com.algorithms.datastructures.bst;

import java.util.List;

public class ReconstructBSTSolution2 {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public int rootIdx;

        public TreeInfo(int rootIdx) {
            this.rootIdx = rootIdx;
        }
    }

    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
        TreeInfo treeInfo = new TreeInfo(0);
        return reconstructBstUsingBounds(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
    }

    private BST reconstructBstUsingBounds(int lowerBound, int upperBound, List<Integer> preOrderTraversalValues, TreeInfo treeInfo) {
        // If rootIdx is equal to the size of the array, that means that we have arrived to the last node
        // of the BST, so we just return null, as it is not going to have any children
        if (preOrderTraversalValues.size() == treeInfo.rootIdx) {
            return null;
        }

        int rootValue = preOrderTraversalValues.get(treeInfo.rootIdx);

        // The rootValue has to be strictly less than lowerBound because the lower bound
        // is one of the constraints for the nodes in our right sub tree
        // and we are ok with nodes in the right sub tree being equal to the lower bound
        // just not smaller than the lower bound.
        // So that's why we don't have to set the symbol less and equal in the lowerBound
        // (rootValue <= lowerBound) because otherwise we would be returning none
        // if the root value was equal to the lower bound, where that's just not valid
        // and we wanna be able to have a node that is the same value
        // as the lower bound in the right sub tree.
        if (rootValue < lowerBound || rootValue >= upperBound) {
            return null;
        }

        treeInfo.rootIdx++;

        BST leftChild = reconstructBstUsingBounds(lowerBound, rootValue, preOrderTraversalValues, treeInfo);
        BST rightChild = reconstructBstUsingBounds(rootValue, upperBound, preOrderTraversalValues, treeInfo);

        BST result = new BST(rootValue);
        result.left = leftChild;
        result.right = rightChild;

        return result;
    }
}
