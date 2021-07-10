package com.algorithms.datastructures;

import com.algorithms.datastructures.utils.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveNthFromEndTest {
    private RemoveNthFromEnd sut;

    @BeforeEach
    public void setUp() {
        sut = new RemoveNthFromEnd();
    }

    @Test
    public void removeNthFromEnd() {
        ListNode listNode = sut.removeNthFromEnd(buildListNode(), 2);
        assertEquals(1, listNode.val);
        assertEquals(2, listNode.next.val);
        assertEquals(3, listNode.next.next.val);
        assertEquals(5, listNode.next.next.next.val);
    }

    @Test
    public void removeNthFromEndApproach1() {
        ListNode listNode = sut.removeNthFromEndApproach1(buildListNode(), 2);
        assertEquals(1, listNode.val);
        assertEquals(2, listNode.next.val);
        assertEquals(3, listNode.next.next.val);
        assertEquals(5, listNode.next.next.next.val);
    }

    @Test
    public void removeNthFromEndApproach2() {
        ListNode listNode = sut.removeNthFromEndApproach2(buildListNode(), 2);
        assertEquals(1, listNode.val);
        assertEquals(2, listNode.next.val);
        assertEquals(3, listNode.next.next.val);
        assertEquals(5, listNode.next.next.next.val);
    }

    private ListNode buildListNode() {
        final ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        return listNode;
    }
}
