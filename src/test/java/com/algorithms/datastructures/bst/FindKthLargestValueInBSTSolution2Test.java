package com.algorithms.datastructures.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindKthLargestValueInBSTSolution2Test {
    @Test
    public void TestCase1() {
        FindKthLargestValueInBSTSolution2.BST root = new FindKthLargestValueInBSTSolution2.BST(15);
        root.left = new FindKthLargestValueInBSTSolution2.BST(5);
        root.left.left = new FindKthLargestValueInBSTSolution2.BST(2);
        root.left.left.left = new FindKthLargestValueInBSTSolution2.BST(1);
        root.left.left.right = new FindKthLargestValueInBSTSolution2.BST(3);
        root.left.right = new FindKthLargestValueInBSTSolution2.BST(5);
        root.right = new FindKthLargestValueInBSTSolution2.BST(20);
        root.right.left = new FindKthLargestValueInBSTSolution2.BST(17);
        root.right.right = new FindKthLargestValueInBSTSolution2.BST(22);
        int k = 3;
        int expected = 17;
        var actual = new FindKthLargestValueInBSTSolution2().findKthLargestValueInBst(root, k);
        assertTrue(expected == actual);
    }
}
