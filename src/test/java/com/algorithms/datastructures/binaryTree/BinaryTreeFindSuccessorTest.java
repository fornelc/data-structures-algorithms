package com.algorithms.datastructures.binaryTree;

import org.junit.jupiter.api.Test;

public class BinaryTreeFindSuccessorTest {
    @Test
    public void TestCase1() {
        BinaryTreeFindSuccessor.BinaryTree root = new BinaryTreeFindSuccessor.BinaryTree(1);
        root.left = new BinaryTreeFindSuccessor.BinaryTree(2);
        root.left.parent = root;
        root.right = new BinaryTreeFindSuccessor.BinaryTree(3);
        root.right.parent = root;
        root.left.left = new BinaryTreeFindSuccessor.BinaryTree(4);
        root.left.left.parent = root.left;
        root.left.right = new BinaryTreeFindSuccessor.BinaryTree(5);
        root.left.right.parent = root.left;
        root.left.left.left = new BinaryTreeFindSuccessor.BinaryTree(6);
        root.left.left.left.parent = root.left.left;
        BinaryTreeFindSuccessor.BinaryTree node = root.left.right;
        BinaryTreeFindSuccessor.BinaryTree expected = root;
        BinaryTreeFindSuccessor.BinaryTree output = new BinaryTreeFindSuccessor().findSuccessor(root, node);
        assert (expected == output);
    }
}
