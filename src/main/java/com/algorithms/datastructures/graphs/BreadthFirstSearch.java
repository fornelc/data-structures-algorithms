package com.algorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: https://www.algoexpert.io/questions/Breadth-first%20Search
 *
 * How to Solve:
 * The Breadth-first Search algorithm works by traversing a graph level by level.
 * In other words, before traversing any Node's children Nodes, its sibling nodes must be traversed.
 *
 * Try using a queue to store all of the future Nodes that you will need to explore as your traverse the graph.
 * By adding Nodes' children Nodes to the queue every time you explore them
 * and by using the First-In-First-Out property of the queue,
 * you can traverse the graph in a Breadth-first Search way.
 * And add every Node's name to the input array as you traverse the graph.
 *
 * Space & Time Complexity
 *
 * O(v + e) time | O(v) space - where v is the number of vertices of the input graph and e is the number of edges of the input graph
 *
 * It is O(v + e) time, because we only loop through as many edges as we have and then we append to our final array
 * the names of as many vertices as we have.
 *
 * It is O(v) space, because of two reasons:
 *  1. We're storing an array of the node name. We're returning an array of length v.
 *  2. Also because in the worst case our queue might have a one point a length of v minus one,
 *  if our root node has every other node in the graph amongst its direct children.
 *
 * * Vertices would be the nodes and edges would be the number of edges connecting the nodes.
 */
public class BreadthFirstSearch {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                array.add(node.name);
                queue.addAll(node.children);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
