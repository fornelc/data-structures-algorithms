package com.algorithms.datastructures.greedyAlgorithms;

import java.util.Arrays;

/**
 * Source: https://www.algoexpert.io/questions/Minimum%20Waiting%20Time
 *
 * How to solve:
 *
 * Even though you don't need to return the actual order
 * in which the queries will be executed to minimize the total waiting time,
 * it's important to determine what this order should be.
 *
 * Solve this problem with constant space, by mutating the input array provided.
 *
 * Sort the input array in place, and execute the shortest queries in their sorted order.
 * This should allow you to calculate the minimum waiting time.
 *
 * Create a variable to store the total waiting time,
 * and iterate through the sorted input array.
 * At each iteration, multiply the number of queries left by the duration of the current query,
 * as all queries after it are going to have to wait the seconds of the current query,
 * and add the result of the multiplication to the total waiting time.
 *
 * O(nlogn) time | O(1) space - where n is the number of queries
 *
 * The reason the time is O(nlogn) is because the first step in our algorithm is to sort the input array.
 * And we know that the fastest way that we can sort the input array,
 * no matter what method we decide to use is going to be O(nlogn).
 *
 * Then our next step is to simply iterate through the sorted order and come up with the total.
 * That's gonna take a total of N time. So we have an N log N step,
 * and then a step that takes N time.
 * So we could write out N log N + N as our time complexity,
 * but we know that N log N is greater than N.
 * So we can simply reduce it to O(nlogn) using big O notation.
 *
 * About the space, due to the fact that we can mutate the input array
 * and we're gonna sort it in place, is actually constant space or O(1).
 *
 * Why is called greedy algorithm
 *
 * Because we make a greedy choice at each step.
 * When we're picking the order,
 * every single time we pick the next query to execute or the first query to execute,
 * we pick the shortest one,
 * and that is a greedy choice.
 * So hence we call this algorithm a greedy algorithm.
 *
 */
public class MinimumWaitingTime {
    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int totalWait = 0;
        int length = queries.length - 1;
        for (int i = 0; i < length; i++) {
            int queriesLeft = length - i;
            totalWait += queries[i] * queriesLeft;
        }

        return totalWait;
    }
}
