package com.algorithms.datastructures.binaryTree;

public class BinaryTreeDiameter {
    public int binaryTreeDiameter(BinaryTree tree) {
        return getTreeInfo(tree).diameter;
    }

    public TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTree = getTreeInfo(tree.left);
        TreeInfo rightTree = getTreeInfo(tree.right);

        int lengthPathThroughRoot = leftTree.height + rightTree.height;
        int maxSubTreeDiameter = Math.max(leftTree.diameter, rightTree.diameter);
        int currentDiameter = Math.max(lengthPathThroughRoot, maxSubTreeDiameter);
        int currentHeight = Math.max(leftTree.height, rightTree.height) + 1;

        return new TreeInfo(currentDiameter, currentHeight);
    }

    static class TreeInfo {
        public int diameter;
        public int height;
        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }

    }

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
