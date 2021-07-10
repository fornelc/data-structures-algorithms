package com.algorithms.datastructures.linkedLists;

public class SumOfLinkedLists {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList newLinkedListHeadPointer = new LinkedList(0);
        LinkedList currentNode = newLinkedListHeadPointer;
        int carry = 0;

        LinkedList nodeOne = linkedListOne;
        LinkedList nodeTwo = linkedListTwo;

        while (nodeOne != null || nodeTwo != null || carry != 0) {
            int valueOne = nodeOne != null ? nodeOne.value : 0;
            int valueTwo = nodeTwo != null ? nodeTwo.value : 0;
            int sumOfValues = valueOne + valueTwo + carry;

            int nodeValue = sumOfValues % 10;
            currentNode.next = new LinkedList(nodeValue);
            currentNode = currentNode.next;

            carry = sumOfValues / 10;
            nodeOne = nodeOne != null ? nodeOne.next : null;
            nodeTwo = nodeTwo != null ? nodeTwo.next : null;
        }

        return newLinkedListHeadPointer.next;
    }
}
