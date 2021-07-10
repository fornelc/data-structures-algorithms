package com.algorithms.datastructures.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeConstructionRecursiveTest {
    @Test
    public void TestCase1() {
        var root = new BinarySearchTreeConstructionRecursive.BST(10);
        root.left = new BinarySearchTreeConstructionRecursive.BST(5);
        root.left.left = new BinarySearchTreeConstructionRecursive.BST(2);
        root.left.left.left = new BinarySearchTreeConstructionRecursive.BST(1);
        root.left.right = new BinarySearchTreeConstructionRecursive.BST(5);
        root.right = new BinarySearchTreeConstructionRecursive.BST(15);
        root.right.left = new BinarySearchTreeConstructionRecursive.BST(13);
        root.right.left.right = new BinarySearchTreeConstructionRecursive.BST(14);
        root.right.right = new BinarySearchTreeConstructionRecursive.BST(22);

        root.insert(12);
        assertTrue(root.right.left.left.value == 12);

        root.remove(10);
        assertTrue(root.contains(10) == false);
        assertTrue(root.value == 12);

        assertTrue(root.contains(15));
    }
}
