package com.algorithms.datastructures.graphs;

/**
 * Source: https://www.algoexpert.io/questions/Cycle%20In%20Graph
 *
 * How to solve:
 * There are multiple ways to solve this problem, and they all make use of a depth-first-search traversal.
 *
 * When traversing a graph using depth-first search,
 * a back edge is an edge from a node to one of its ancestors in the depth-first-search tree,
 * and a back edge denotes the presence of a cycle.
 *
 * To find back edges, you'll need to keep track of which nodes you've already visited
 * and which nodes are ancestors of the current node in the depth-first-search tree.
 * There are a few ways to do this, but one approach is to recursively traverse the graph
 * and to keep track of which nodes have been visited in general
 * and which nodes have been visited in the current recursion stack;
 * you can do so with two separate data structures.
 * If you reach a node that has an edge to a node that's already in the recursion stack,
 * then you've detected a back edge, and there's a cycle in the graph.
 *
 * Similar to the previous hint, you can also detect a back edge by performing a 3-color depth-first search.
 * Each node is colored white to start; recursively traverse through the graph,
 * coloring the current node grey and then calling the recursive traversal function on all of its neighbors.
 * After traversing all the neighbors, color the current node black to signify that it's "done."
 * If you ever find an edge to a node that's grey, you've found a back edge, and there's a cycle in the graph.
 *
 * Space & Time complexity
 * O(v + e) time | O(v) space - where v is the number of vertices and e is the number of edges in the graph.
 *
 * The reason is O(v) space is because we use V space for the auxiliary data structures in both solutions,
 * and the reason is O(v + e) time is because our depth first search needs to look at all of the vertices
 * and all of the edges.
 */
public class CycleInGraph {
    public boolean cycleInGraph(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        boolean[] inStack = new boolean[edges.length];

        for (int i = 0; i < edges.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (findCycle(visited, inStack, i, edges)) {
                return true;
            }

        }

        return false;
    }

    private boolean findCycle(boolean[] visited, boolean[] inStack, int i, int[][] edges) {
        visited[i] = true;
        inStack[i] = true;

        for (int edge : edges[i]) {
            if (inStack[edge]) {
                return true;
            }

            if (findCycle(visited, inStack, edge, edges)) {
                return true;
            }
        }

        inStack[i] = false;
        return inStack[i];
    }
}
