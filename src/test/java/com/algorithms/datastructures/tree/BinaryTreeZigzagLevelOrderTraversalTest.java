package com.algorithms.datastructures.tree;

import com.algorithms.datastructures.utils.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeZigzagLevelOrderTraversalTest {
    private BinaryTreeZigzagLevelOrderTraversal sut;

    @BeforeEach
    public void setUp() {
        sut = new BinaryTreeZigzagLevelOrderTraversal();
    }

    @Test
    public void zigzagLevelOrder_returnsZigzagOrderTraversal() {
        TreeNode treeNode = buildTree();
        assertEquals(3, sut.zigzagLevelOrder(treeNode).get(0).get(0).intValue());
        assertEquals(20, sut.zigzagLevelOrder(treeNode).get(1).get(0).intValue());
        assertEquals(9, sut.zigzagLevelOrder(treeNode).get(1).get(1).intValue());
        assertEquals(15, sut.zigzagLevelOrder(treeNode).get(2).get(0).intValue());
        assertEquals(7, sut.zigzagLevelOrder(treeNode).get(2).get(1).intValue());
    }

    private TreeNode buildTree() {
        return new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    }
}
