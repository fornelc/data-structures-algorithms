package com.algorithms.datastructures;

import com.algorithms.datastructures.utils.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NodeConnectTest {
    private NodeConnect sut;

    @BeforeEach
    public void setUp() {
        sut = new NodeConnect();
    }

    @Test
    public void connect() {
        Node result = sut.connectApproach2(buildNode());
        assertNull(result.next);
        assertEquals(3, result.left.next.val);
        assertEquals(6, result.left.right.next.val);
    }

    private Node buildNode() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        return node;
    }
}
