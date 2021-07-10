package com.algorithms.datastructures.bst;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReconstructBSTSolution2Test {
    public List<Integer> getDfsOrder(ReconstructBSTSolution2.BST node, List<Integer> values) {
        values.add(node.value);
        if (node.left != null) {
            getDfsOrder(node.left, values);
        }
        if (node.right != null) {
            getDfsOrder(node.right, values);
        }
        return values;
    }

    @Test
    public void TestCase1() {
        List<Integer> preOrderTraversalValues =
                new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 3, 17, 19, 18));
        ReconstructBSTSolution2.BST tree = new ReconstructBSTSolution2.BST(10);
        tree.left = new ReconstructBSTSolution2.BST(4);
        tree.left.left = new ReconstructBSTSolution2.BST(2);
        tree.left.left.left = new ReconstructBSTSolution2.BST(1);
        tree.left.right = new ReconstructBSTSolution2.BST(3);
        tree.right = new ReconstructBSTSolution2.BST(17);
        tree.right.right = new ReconstructBSTSolution2.BST(19);
        tree.right.right.left = new ReconstructBSTSolution2.BST(18);
        List<Integer> expected = getDfsOrder(tree, new ArrayList<Integer>());
        var actual = new ReconstructBSTSolution2().reconstructBst(preOrderTraversalValues);
        List<Integer> actualValues = getDfsOrder(actual, new ArrayList<Integer>());
        assertTrue(expected.equals(actualValues));
    }
}
