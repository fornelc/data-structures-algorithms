package com.algorithms.datastructures.arrays;

import java.util.List;

public class MoveElementToEnd {
    /**
     * You're given an array of integers and an integer. Write a function that moves
     * all instances of that integer in the array to the end of the array and returns
     * the array.
     * Sample Input
     * array = [2, 1, 2, 2, 2, 3, 4, 2]
     * toMove = 2
     *
     * Sample Output
     * [1, 3, 4, 2, 2, 2, 2, 2] // the numbers 1, 3, and 4 could be ordered differently
     *
     * https://www.algoexpert.io/questions/Move%20Element%20To%20End
     *
     * How to solve:
     * Following Hint #2, set two pointers at the start and end of the array, respectively.
     * Move the right pointer inwards so long as it points to the integer to move,
     * and move the left pointer inwards so long as it doesn't point to the integer to move.
     * When both pointers aren't moving, swap their values in place.
     * Repeat this process until the pointers pass each other.
     *
     * Hints that points you to this algorithm:
     * 1. It is a linear solution.
     * 2. You experiment with the idea of multiple pointers, because you maybe are gonna need
     * because you are swapping values. You can quickly come with the algorithm's solution.
     *
     * O(n) time | O(1) space - where n is the length of the array
     * It is n time, because we visit each index of the array only once, and we perform swaps,
     * but these swaps are constant time operations.
     * It is constant space, because we are not using any auxiliary data structure,
     * we are doing the swap in place.
     * @param array
     * @param toMove
     * @return
     */
    public static List<Integer> moveElementToEndAlgoSolution(List<Integer> array, int toMove) {
        int i = 0;
        int j = array.size() - 1;
        while (i < j) {
            while (i < j && array.get(j).equals(toMove)) {
                j--;
            }
            if (array.get(i).equals(toMove)) {
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
            }
            i++;
        }
        return array;
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int i = 0;
        int j = array.size() - 1;
        while (i < j) {
            if (array.get(j).equals(toMove)) {
                j--;
            } else if (array.get(i).equals(toMove)) {
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                i++;
                j--;
            } else {
                i++;
            }
        }
        return array;
    }
}
