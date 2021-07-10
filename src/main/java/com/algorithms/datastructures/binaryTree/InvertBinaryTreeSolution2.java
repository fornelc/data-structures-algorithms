package com.algorithms.datastructures.binaryTree;

public class InvertBinaryTreeSolution2 {

    public static void invertBinaryTree(BinaryTree tree) {
        if (tree == null) {
            return;
        }
        swapNodes(tree);
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    private static void swapNodes(InvertBinaryTreeSolution2.BinaryTree current) {
        InvertBinaryTreeSolution2.BinaryTree leftNode = current.left;
        current.left = current.right;
        current.right = leftNode;
    }

    static class BinaryTree {
        public int value;
        public InvertBinaryTreeSolution2.BinaryTree left;
        public InvertBinaryTreeSolution2.BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
