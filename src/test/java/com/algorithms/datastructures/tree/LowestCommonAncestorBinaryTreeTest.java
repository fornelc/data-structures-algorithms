package com.algorithms.datastructures.tree;

import com.algorithms.datastructures.utils.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowestCommonAncestorBinaryTreeTest {
    private LowestCommonAncestorBinaryTree sut;

    @BeforeEach
    public void setUp() {
        sut = new LowestCommonAncestorBinaryTree();
    }

    @Test
    public void lowestCommonAncestor_returnLCA() {
//        assertEquals(3, sut.lowestCommonAncestor(buildTree(), 5, 1).val);
        assertEquals(2, sut.lowestCommonAncestor(buildTree2(), 9, 11).val);
    }

    private TreeNode buildTree() {
        return new TreeNode(3,
                new TreeNode(5, new TreeNode(6),
                        new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(0), new TreeNode(8)));

    }

    private TreeNode buildTree2() {
        return new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                new TreeNode(9)),
                        new TreeNode(5,
                                new TreeNode(10),
                                new TreeNode(11))),
                new TreeNode(3,
                        new TreeNode(6,
                                new TreeNode(12),
                                new TreeNode(13)),
                        new TreeNode(7,
                                new TreeNode(14),
                                new TreeNode(15))));

    }
}
