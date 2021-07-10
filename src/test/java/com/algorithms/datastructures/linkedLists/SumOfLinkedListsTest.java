package com.algorithms.datastructures.linkedLists;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SumOfLinkedListsTest {
    @Test
    public void TestCase1() {
        SumOfLinkedLists.LinkedList ll1 = addMany(new SumOfLinkedLists.LinkedList(2), new int[] {4, 7, 1});
        SumOfLinkedLists.LinkedList ll2 = addMany(new SumOfLinkedLists.LinkedList(9), new int[] {4, 5});
        SumOfLinkedLists.LinkedList expected = addMany(new SumOfLinkedLists.LinkedList(1), new int[] {9, 2, 2});
        var actual = new SumOfLinkedLists().sumOfLinkedLists(ll1, ll2);
        assertTrue(getNodesInArray(expected).equals(getNodesInArray(actual)));
    }

    public SumOfLinkedLists.LinkedList addMany(SumOfLinkedLists.LinkedList linkedList, int[] values) {
        var current = linkedList;
        while (current.next != null) {
            current = current.next;
        }
        for (var value : values) {
            current.next = new SumOfLinkedLists.LinkedList(value);
            current = current.next;
        }
        return linkedList;
    }

    public ArrayList<Integer> getNodesInArray(SumOfLinkedLists.LinkedList linkedList) {
        ArrayList<Integer> nodeValues = new ArrayList<Integer>();
        SumOfLinkedLists.LinkedList current = linkedList;
        while (current != null) {
            nodeValues.add(current.value);
            current = current.next;
        }
        return nodeValues;
    }
}
