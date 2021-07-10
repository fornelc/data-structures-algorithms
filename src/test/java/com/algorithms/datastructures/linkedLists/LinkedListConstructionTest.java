package com.algorithms.datastructures.linkedLists;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListConstructionTest {
    private List<Integer> getNodeValuesHeadToTail(LinkedListConstruction.DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        LinkedListConstruction.Node node = linkedList.head;
        while (node != null) {
            values.add(node.value);
            node = node.next;
        }
        return values;
    }

    private List<Integer> getNodeValuesTailToHead(LinkedListConstruction.DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        LinkedListConstruction.Node node = linkedList.tail;
        while (node != null) {
            values.add(node.value);
            node = node.prev;
        }
        return values;
    }

    private void bindNodes(LinkedListConstruction.Node nodeOne, LinkedListConstruction.Node nodeTwo) {
        nodeOne.next = nodeTwo;
        nodeTwo.prev = nodeOne;
    }

    private boolean compare(List<Integer> array1, int[] array2) {
        if (array1.size() != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.size(); i++) {
            if (array1.get(i) != array2[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void TestCase1() {
        LinkedListConstruction.DoublyLinkedList linkedList = new LinkedListConstruction.DoublyLinkedList();
        LinkedListConstruction.Node one = new LinkedListConstruction.Node(1);
        LinkedListConstruction.Node two = new LinkedListConstruction.Node(2);
        LinkedListConstruction.Node three = new LinkedListConstruction.Node(3);
        LinkedListConstruction.Node three2 = new LinkedListConstruction.Node(3);
        LinkedListConstruction.Node three3 = new LinkedListConstruction.Node(3);
        LinkedListConstruction.Node four = new LinkedListConstruction.Node(4);
        LinkedListConstruction.Node five = new LinkedListConstruction.Node(5);
        LinkedListConstruction.Node six = new LinkedListConstruction.Node(6);
        bindNodes(one, two);
        bindNodes(two, three);
        bindNodes(three, four);
        bindNodes(four, five);
        linkedList.head = one;
        linkedList.tail = five;

        linkedList.setHead(four);
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 3, 5}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {5, 3, 2, 1, 4}));

        linkedList.setTail(six);
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 3, 5, 6}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 3, 2, 1, 4}));

        linkedList.insertBefore(six, three);
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 3, 6}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 3, 5, 2, 1, 4}));

        linkedList.insertAfter(six, three2);
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 3, 6, 3}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {3, 6, 3, 5, 2, 1, 4}));

        linkedList.insertAtPosition(1, three3);
        assertTrue(
                compare(getNodeValuesHeadToTail(linkedList), new int[] {3, 4, 1, 2, 5, 3, 6, 3}));
        assertTrue(
                compare(getNodeValuesTailToHead(linkedList), new int[] {3, 6, 3, 5, 2, 1, 4, 3}));

        linkedList.removeNodesWithValue(3);
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 6}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 2, 1, 4}));

        linkedList.remove(two);
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 5, 6}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 1, 4}));

        assertTrue(linkedList.containsNodeWithValue(5));
    }
}
