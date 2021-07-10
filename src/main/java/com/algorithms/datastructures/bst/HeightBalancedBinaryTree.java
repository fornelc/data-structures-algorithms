package com.algorithms.datastructures.bst;

public class HeightBalancedBinaryTree {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    class TreeInfo {
        public boolean isBalanced;
        public int height;

        TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        TreeInfo treeInfo = retrieveBinaryTreeInfo(tree);
        return treeInfo.isBalanced;
    }

    private TreeInfo retrieveBinaryTreeInfo(BinaryTree node) {
        if (node == null) {
            return new TreeInfo(true, -1);
        }

        TreeInfo leftSubTree = retrieveBinaryTreeInfo(node.left);
        TreeInfo rightSubTree = retrieveBinaryTreeInfo(node.right);

        boolean isBalanced = leftSubTree.isBalanced
                            && rightSubTree.isBalanced
                            && Math.abs(leftSubTree.height - rightSubTree.height) <= 1;

        int height = Math.max(leftSubTree.height, rightSubTree.height) + 1;

        return new TreeInfo(isBalanced, height);
    }
}
