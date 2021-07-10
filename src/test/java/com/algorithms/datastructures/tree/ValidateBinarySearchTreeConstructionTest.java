package com.algorithms.datastructures.tree;

import com.algorithms.datastructures.utils.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateBinarySearchTreeConstructionTest {
    private ValidateBinarySearchTree sut;

    @BeforeEach
    public void setUp() {
        sut = new ValidateBinarySearchTree();
    }

    @Test
    public void isValidBST_passValidBST_returnTrue() {
        TreeNode treeNode = buildValidTreeNode();
        assertTrue(sut.isValidBST(treeNode));
    }

    @Test
    public void isValidBST_passNoValidBST_returnFalse() {
//        assertFalse(sut.isValidBST(buildNoValidTreeNode()));
//        assertFalse(sut.isValidBST(buildNoValidTreeNode2()));
//        assertFalse(sut.isValidBST(buildNoValidTreeNode3()));
        assertFalse(sut.isValidBST(buildNoValidTreeNode4()));
    }

    private TreeNode buildValidTreeNode() {
        return new TreeNode(2, new TreeNode(1), new TreeNode(3));
    }

    private TreeNode buildNoValidTreeNode() {
        return new TreeNode(5, new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6)));
    }

    private TreeNode buildNoValidTreeNode2() {
        return new TreeNode(5, new TreeNode(6),
                new TreeNode(7, new TreeNode(3), new TreeNode(8)));
    }

    private TreeNode buildNoValidTreeNode3() {
        return new TreeNode(5, new TreeNode(1),
                new TreeNode(6, new TreeNode(4), new TreeNode(7)));
    }

    private TreeNode buildNoValidTreeNode4() {
        return new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(6)),
                new TreeNode(5));
    }

}
