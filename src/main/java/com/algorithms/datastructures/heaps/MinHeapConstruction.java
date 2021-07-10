package com.algorithms.datastructures.heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * Source: https://www.algoexpert.io/questions/Min%20Heap%20Construction
 *
 * How to Solve:
 *
 * For the buildHeap(), remove(), and insert() methods of the Heap,
 * you will need to use the siftDown() and siftUp() methods.
 * These two methods should essentially allow you to take any node in the heap
 * and move it either down or up in the heap until it's in its final, appropriate position.
 * This can be done by comparing the node in question to its child nodes in the case of siftDown()
 * or to its parent node in the case of siftUp().
 *
 * In an array-based Heap, you can easily access a node's children nodes and parent node by using the nodes' indices.
 * If a node is located at index i, then its children nodes are located at indices 2 * i + 1 and 2 * i + 2,
 * and its parent node is located at index Math.floor((i - 1) / 2).
 *
 * To implement the buildHeap() method, you can either sift every node in the input array down to its final,
 * correct position, or you can sift every node in the input array up to its final, correct position.
 * What are the runtime implications of both approaches?
 *
 * Remove: In a heap, the main removal function is gonna be removing the root node.
 * You wanna remove, 'cause as we said, the heap isn't really sorted,
 * so the only value that you can truly extract very easily is the root value which is the smallest value,
 * or if you're in a Max Heap, the greatest value.
 * So if we wanna remove the root node from the heap, what we're gonna do is we're gonna swap the root node,
 * with the final value in the heap.
 * Then we pop the root node off the heap, that now it was at the end of our list after swapping it,
 * and afterwards we call the sift down method, so we're gonna take the new value in the root of the heap
 * and sift it down in the heap until it's in its correct position.
 *
 * Insert: When we insert a value, after we add it to the end of the heap,
 * we wanna sift it up to its correct position.
 *
 * SiftUp: The Sift Up method is gonna continuously swap the current node that we've inserted with its parent
 * until it's in its correct position.
 *
 * SiftDown: Sifting down is a tiny bit more involved than sifting up,
 * because instead of comparing a node to its parent node,
 * you're comparing it to both of its children nodes.
 * We wanna find the smallest of its children nodes and swap it with that node if it's still out of order.
 *
 * BuildHeap: Build Heap is a way of building a heap out of an array that is not at all a heap,
 * so you give it, it could be the most unsorted array in the world,
 * and you build the heap out of that array in place.
 * To build heap we are going to use the SiftDown method.
 * Basically you're given an array and you're gonna be calling the Sift Down method on every parent node,
 * you will be effectively positioning every parent node correctly in the heap,
 * and you start at the very last parent node.
 *
 * Which methods (siftDown() or siftUp()) will insert() and remove() utilize? What about peek()?
 *
 * Space & Time complexity:
 *
 * BuildHeap: O(n) time | O(1) space - where n is the length of the input array
 *
 * BuildHeap is O(n) time because we're almost calling SiftDown method on end nodes.
 * Because the more nodes we have in our heap, the more nodes we're calling Sift Down on.
 * So, naturally you would expect Build Heap to run in O(nlog(n)) time,
 * 'cause you're calling Sift Down which runs in log(n) time,
 * roughly N times.
 * But it turns out it's not O(nlog(n)) time,
 * it's only O(n) time.
 * Basically the idea is that Sift Down isn't equal for every node that you call it on.
 * Imagine you call the Sift Down method on a leaf node,
 * you're not sifting it down any level because it's at the very bottom level.
 * So, then you go one level up. When you call the Sift Down method on all the nodes at that level,
 * you're essentially only gonna sift them down one level, so it is gonna be constant time, runs in O(1) time.
 * Then you go one level up again, and you call the Sift Down method,
 * and you are only going down two levels.
 * So basically, the higher up in the heap you are, the longer Sift Down takes to run.
 * When you call Sift Down on the root node, then it genuinely takes O(log(N)) time.
 * But when you call Sift Down on the very bottom nodes, it takes O(0) time,
 * 'cause you're not doing any computations.
 * When you call it on the nodes at the first level, or at the second to last level,
 * it takes O(1) time because you're only doing, you're only sifting them down one level.
 * And because you've got the majority of the nodes are at the bottom,
 * and you've only got one node at the top,
 * basically the levels at which Sift Down takes a long time to run,
 * you've only got a few nodes on which you call Sift Down.
 * So, when Sift Down takes genuinely O(log(n)) time you're only calling it on one node, in the root node.
 * When it takes O(2) time you're only calling it on the second level.
 * So, the majority of the nodes that you call Sift Down on are at the bottom of the tree
 * and Sift Down doesn't take much time for them.
 * What this means basically is that you can kind of represent the run time of the Build Heap method in a sort of
 * mathematical Taylor series that converges to O(n).
 *
 * If you implement Build Heap using Sift Up,
 * then in that case it's not gonna run in O(n) time.
 * Using SiftUp you'll notice that the only time that Sift Up takes O(0) time is at the root node
 * where you've only got one node.
 * Then at the second level, where you've got two nodes, it takes O(1) time to sift them up
 * because you have to sift them up by one level.
 * And then all of the nodes at the bottom which is the majority of the nodes in the heap,
 * if you call Sift up on them, it takes O(log(n)) time for all of them.
 * So, if you implement Build Heap with the Sift Up method,
 * then Build Heap runs in O(nlog(n)) time. *
 *
 * SiftDown: O(log(n)) time | O(1) space - where n is the length of the heap
 * SiftUp: O(log(n)) time | O(1) space - where n is the length of the heap
 *
 * SiftDown and SiftUp are O(log(n)) because every time we swap a node,
 * we're essentially eliminating half the tree.
 * Every time we're kind of eliminating half the remainder of the tree that we're never gonna traverse thereafter.
 *
 * Peek: O(1) | O(1)
 * Remove: O(log(n)) time | O(1) space - where n is the length of the heap
 * Insert: O(log(n)) time | O(1) space - where n is the length of the heap
 *
 * Remove and Insert are O(log(n)) time because they are pretty much just calling the SiftUp and SiftDown methods.
 *
 * In terms of space complexity it's O(1), because this all happens in place in the array
 * or in our array representation of the heap and we never allocate extra memory.
 */
public class MinHeapConstruction {
    public static class MinHeap {
        public static List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int firstParentIdx = (array.size() - 2) / 2;
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                siftDown(currentIdx, array.size() - 1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int child1Idx = currentIdx * 2 + 1;
            while (child1Idx <= endIdx) {
                int child2Idx = currentIdx * 2 + 2;
                int idxToReplace;
                if (child2Idx <= endIdx && heap.get(child2Idx) < heap.get(child1Idx)) {
                    idxToReplace = child2Idx;
                } else {
                    idxToReplace = child1Idx;
                }
                if (heap.get(currentIdx) > heap.get(idxToReplace)) {
                    swap(idxToReplace, currentIdx, heap);
                    currentIdx = idxToReplace;
                    child1Idx = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            int parentIdx = (currentIdx - 1) / 2;
            while (currentIdx >= 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            swap(0, heap.size() - 1, heap);
            int nodeRemoved = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0,heap.size() - 1, heap);
            return nodeRemoved;
        }

        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }

        private void swap(int i, int j, List<Integer> heap) {
            int temp = heap.get(j);
            heap.set(j, heap.get(i));
            heap.set(i, temp);
        }
    }
}
