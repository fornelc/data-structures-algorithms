package com.algorithms.datastructures.graphs;

/**
 * Source, how to solve and Space & time complexity in solution1.
 */
public class CycleInGraphSolution2 {

    public boolean cycleInGraph(int[][] edges) {
        int[] status = new int[edges.length]; // 0 unvisited, 1 in stack, 2 finished
        for (int i = 0; i < edges.length; i++) {
            if (status[i] == 2) {
                continue;
            }
            if (findCycle(status, i, edges)) {
                return true;
            }

        }

        return false;
    }

    private boolean findCycle(int[] status, int i, int[][] edges) {
        status[i] = 1;

        for (int edge : edges[i]) {
            if (status[edge] == 1) {
                return true;
            }

            if (findCycle(status, edge, edges)) {
                return true;
            }
        }

        status[i] = 2;
        return false;
    }
}
