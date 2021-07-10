package com.algorithms.datastructures;

import com.algorithms.datastructures.utils.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTwoNumbersTest {

    private AddTwoNumbers sut;

    @BeforeEach
    public void setUp() {
        sut = new AddTwoNumbers();
    }

    @Test
    public void addTwoNumbers() {
        ListNode listNode = sut.addTwoNumbers(buildListNode(2,4,3), buildListNode(5,6,4));
        assertEquals(listNode.val, 7);
        assertEquals(listNode.next.val, 0);
        assertEquals(listNode.next.next.val, 8);
    }

    private ListNode buildListNode(int value1, int value2, int value3) {
        ListNode listNode = new ListNode(value1);
        listNode.next = new ListNode(value2);
        listNode.next.next = new ListNode(value3);
        return listNode;
    }
}
