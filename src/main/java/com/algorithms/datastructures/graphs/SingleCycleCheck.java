package com.algorithms.datastructures.graphs;

/**
 * Exercise: https://www.algoexpert.io/questions/Single%20Cycle%20Check
 *
 * How to solve:
 *
 * In order to check if the input array has a single cycle,
 * you have to jump through all of the elements in the array.
 * Keep a counter, jump through elements in the array,
 * and stop once you've jumped through as many elements as are contained in the array.
 *
 * Assume the input array has length n.
 * If you start at index 0 and jump through n elements,
 * the simplest conditions that you can check to see if the array doesn't have a single cycle would be 3,
 * First, let's make sure that we're visiting n elements where n is the length of the input array.
 * Second, the starting element (in this case, the element at index 0) cannot be jumped through more than once,
 * at the very beginning, so long as you haven't jumped through all of the other elements in the array.
 * Third, the (n + 1)th element you jump through, where n is the length of the array,
 * must be the first element you visited: the element at index 0 in this case.
 *
 * There is another not so efficient way to solve it, by having an auxiliary array of length n initialized by zero,
 * and incrementing each index, each time we visit every number by one. And then review the array,
 * to check if each number has been visited at least one time. But this would take O(n) space,
 * so would be a less efficient solution, as the other one would be solved in O(1) space.
 *
 * Time & Space complexity:
 * O(n) time | O(1) space - where n is the length of the input array
 *
 * O(1) space because we just need a couple of extra variables, but we don't need an extra list of length n.
 * O(n) time because we're really just jumping through n elements.
 * And then either we'll have stopped before then and return false.
 * And we'll have found ourselves back at the starting point and therefore,
 * with more than a single cycle,
 * or we'll have found ourselves back up a starting point at the nth element or n plus oneth element.
 * And that is O(n) time.
 */
public class SingleCycleCheck {
    public static boolean hasSingleCycle(int[] array) {
        int numElementsVisited = 0;
        int currentIdx = 0;
        while (numElementsVisited < array.length) {
            if (numElementsVisited > 0 && currentIdx == 0) return false;
            numElementsVisited++;
            currentIdx = getNextIdx(currentIdx, array);
        }
        return currentIdx == 0;
    }

    private static int getNextIdx(int currentIdx, int[] array) {
        int jump = array[currentIdx];
        int nextIdx = (currentIdx + jump) % array.length;
        // We need to handle negative values for the nextIdx calculated using mod,
        // so we need to sum the array length to retrieve the next idx to be visited.
        return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
    }
}
