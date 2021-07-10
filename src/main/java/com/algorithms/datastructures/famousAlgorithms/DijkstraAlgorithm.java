package com.algorithms.datastructures.famousAlgorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Dijsktra's Algorithm
 *
 * What Dijkstra algorithm does, is it keeps track of what it's already seen.
 * It keeps track of the current shortest distance, to each of the nodes in our graph.
 *
 * O(v^2 + e) time | O(v) space - where v is the number of vertices and e is the number of edges in the input graph
 */
public class DijkstraAlgorithm {
    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        int numberOfVertices = edges.length;

        int[] minDistances = new int[numberOfVertices];
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        minDistances[start] = 0;

        Set<Integer> visited = new HashSet<>();

        // O(v) time operation
        while (visited.size() < numberOfVertices) {
            // O(v) time operation
            int[] minDistanceVertex = getMinDistanceVertex(minDistances, visited);
            int currentVertex = minDistanceVertex[0];
            int currentDistance = minDistanceVertex[1];

            if (currentDistance == Integer.MAX_VALUE) {
                break;
            }

            visited.add(currentVertex);

            // O(e) time operation
            for (int[] edge : edges[currentVertex]) {
                // O(1) time operations
                int destination = edge[0];
                int distanceToDestination = edge[1];

                if (visited.contains(destination)) {
                    continue;
                }

                int newDistance = currentDistance + distanceToDestination;
                if (newDistance < minDistances[destination]) {
                    minDistances[destination] = newDistance;
                }
            }
        }

        int[] finalDistances = new int[minDistances.length];
        for (int i = 0; i < minDistances.length; i++) {
            int distance = minDistances[i];
            if (distance == Integer.MAX_VALUE) {
                finalDistances[i] = -1;
            } else {
                finalDistances[i] = distance;
            }
        }

        return finalDistances;
    }

    private int[] getMinDistanceVertex(int[] minDistances, Set<Integer> visited) {
        int currentMinDistance = Integer.MAX_VALUE;
        int currentVertex = -1;

        for (int vertexIdx = 0; vertexIdx < minDistances.length; vertexIdx++) {
            int distance = minDistances[vertexIdx];

            if (visited.contains(vertexIdx)) {
                continue;
            }

            if (distance < currentMinDistance) {
                currentVertex = vertexIdx;
                currentMinDistance = distance;
            }
        }

        return new int[] {currentVertex, currentMinDistance};
    }
}
