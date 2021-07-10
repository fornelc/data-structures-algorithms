package com.algorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: https://www.algoexpert.io/questions/River%20Sizes
 *
 * How to solve:
 * Since you must return the sizes of rivers,
 * which consist of horizontally and vertically adjacent 1s in the input matrix,
 * you must keep track of groups of neighboring 1s as you traverse the matrix.
 * Try treating the matrix as a graph,
 * where each element in the matrix is a node in the graph with up to 4 neighboring nodes
 * (above, below, to the left, and to the right),
 * and traverse it using a popular graph-traversal algorithm like Depth-first Search or Breadth-first Search.
 *
 * By traversing the matrix using DFS or BFS,
 * any time that you encounter a 1 you can traverse the entire river that this 1 is a part of
 * (and keep track of its size) by simply iterating through the given node's neighboring nodes
 * and their own neighboring nodes so long as the nodes are 1s.
 *
 * Naturally, many nodes in the graph will have overlapping neighboring nodes,
 * and as you traverse the matrix, you will undoubtedly encounter nodes that you have previously visited.
 * In order to prevent mistakenly calculating the same river's size multiple times
 * and to avoid doing needless computational work,
 * try keeping track of every node that you visit in an auxiliary data structure
 * and only performing important computations on unvisited nodes.
 * To keep track of the neighbor nodes to visit we can use a Stack data structure.
 *
 * Space & Time complexity:
 *
 * O(wh) time | O(wh) space - where w and h are the width and height of the input matrix.
 * Or we could say O(N) where N is the total number of elements in the matrix.
 *
 * It is O(wh), because we're visiting every single node,
 * and as soon as we visit a node we mark it as visited, we'll never visit it again.
 * And that'll be a constant time operation. And for nodes that we haven't visited,
 * when we look at all of its neighboring nodes, all we're doing are constant time operations too.
 *
 * We end up either skipping them cause we already visited them or we end up visiting them for real,
 * And because every node has at most four neighboring nodes,
 * that's a constant time operation to look at four neighboring nodes
 * that have potentially already been visited.
 *
 * About the space being O(wh), because we're gonna be building the auxiliary data structure,
 * which is just gonna be a matrix of the exact same size.
 * And in the matrix we're gonna hold Booleans false or true,
 * determining whether or not a specific node is visited.
 * And the solution array is never gonna have more space than the auxiliary matrix,
 * because it's only gonna be a one dimensional array of rivers sizes.
 */
public class RiverSizes {
    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                helper(i, j, matrix, visited, sizes);
            }
        }
        return sizes;
    }

    private static void helper(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        int riverSize = 0;
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{i, j});
        while (!stack.isEmpty()) {
            Integer[] nodeToCheck = stack.pop();
            i = nodeToCheck[0];
            j = nodeToCheck[1];
            if(visited[i][j]) {
                continue;
            }
            if(matrix[i][j] == 0) {
                continue;
            }
            riverSize++;
            visited[i][j] = true;
            addNodesToVisit(i, j, matrix, visited, stack);

        }
        if (riverSize > 0) {
            sizes.add(riverSize);
        }
    }

    private static void addNodesToVisit(int i, int j, int[][] matrix, boolean[][] visited, Stack<Integer[]> stack) {
        // When we are looking in the neighboring nodes we are doing constant time operations
        if (i > 0 && !visited[i - 1][j]) {
            stack.add(new Integer[]{i - 1, j});
        }
        if (j > 0 && !visited[i][j - 1]) {
            stack.add(new Integer[]{i, j - 1});
        }
        if (i < matrix.length - 1 && !visited[i + 1][j]) {
            stack.add(new Integer[]{i + 1, j});
        }
        if (j < matrix[0].length - 1 && !visited[i][j + 1]) {
            stack.add(new Integer[]{i, j + 1});
        }
    }
}
