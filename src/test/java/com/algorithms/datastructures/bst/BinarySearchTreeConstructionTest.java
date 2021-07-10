package com.algorithms.datastructures.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeConstructionTest {
    @Test
    public void TestCase1() {
        var root = new BinarySearchTreeConstruction.BST(10);
        root.left = new BinarySearchTreeConstruction.BST(5);
        root.left.left = new BinarySearchTreeConstruction.BST(2);
        root.left.left.left = new BinarySearchTreeConstruction.BST(1);
        root.left.right = new BinarySearchTreeConstruction.BST(5);
        root.right = new BinarySearchTreeConstruction.BST(15);
        root.right.left = new BinarySearchTreeConstruction.BST(13);
        root.right.left.right = new BinarySearchTreeConstruction.BST(14);
        root.right.right = new BinarySearchTreeConstruction.BST(22);

        root.insert(12);
        assertTrue(root.right.left.left.value == 12);

        root.remove(10);
        assertTrue(root.contains(10) == false);
        assertTrue(root.value == 12);

        assertTrue(root.contains(15));
    }
}
