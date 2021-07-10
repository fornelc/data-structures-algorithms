package com.algorithms.datastructures.tree;

import com.algorithms.datastructures.utils.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertIntoBinarySearchTreeConstructionTest {
    private InsertIntoBinarySearchTree sut;

    @BeforeEach
    public void setUp() {
        sut = new InsertIntoBinarySearchTree();
    }

    @Test
    public void insertIntroBST() {
        assertEquals(sut.insertIntoBST(buildTreeNode(), 5).right.left.val, 5);
    }

    @Test
    public void iterativeInsertIntoBST() {
        assertEquals(sut.iterativeInsertIntoBST(buildTreeNode(), 5).right.left.val, 5);
    }

    private TreeNode buildTreeNode() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        return root;
    }
}
