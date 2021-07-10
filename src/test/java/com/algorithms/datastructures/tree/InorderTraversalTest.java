package com.algorithms.datastructures.tree;

import com.algorithms.datastructures.utils.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InorderTraversalTest {
    private InorderTraversal sut;

    @BeforeEach
    public void setUp() {
        sut = new InorderTraversal();
    }

    @Test
    public void inorderTraversal() {
        List<Integer> list = sut.inorderTraversal(buildTree());
        assertEquals(1, list.get(0).intValue());
        assertEquals(3, list.get(1).intValue());
        assertEquals(2, list.get(2).intValue());
    }

    @Test
    public void inorderTraversalApproach2() {
        List<Integer> list = sut.inorderTraversalApproach2(buildTree());
        assertEquals(1, list.get(0).intValue());
        assertEquals(3, list.get(1).intValue());
        assertEquals(2, list.get(2).intValue());
    }

    public TreeNode buildTree() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = null;
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        return treeNode;
    }
}
