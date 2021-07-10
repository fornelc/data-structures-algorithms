package com.algorithms.datastructures.binaryTree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindNodesDistanceKSolution1Test {
    @Test
    public void TestCase1() {

        FindNodesDistanceKSolution1.BinaryTree root = new FindNodesDistanceKSolution1.BinaryTree(1);
        root.left = new FindNodesDistanceKSolution1.BinaryTree(2);
        root.right = new FindNodesDistanceKSolution1.BinaryTree(3);
        root.left.left = new FindNodesDistanceKSolution1.BinaryTree(4);
        root.left.right = new FindNodesDistanceKSolution1.BinaryTree(5);
        root.right.right = new FindNodesDistanceKSolution1.BinaryTree(6);
        root.right.right.left = new FindNodesDistanceKSolution1.BinaryTree(7);
        root.right.right.right = new FindNodesDistanceKSolution1.BinaryTree(8);
        int target = 3;
        int k = 2;
        var expected = new ArrayList<Integer>(Arrays.asList(2, 7, 8));
        var actual = new FindNodesDistanceKSolution1().findNodesDistanceK(root, target, k);
        Collections.sort(actual);
        assertTrue(expected.equals(actual));
    }
}
