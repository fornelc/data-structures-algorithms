package com.algorithms.datastructures.famousAlgorithms;

import java.util.*;

/**
 *
 * You're given a list of arbitrary jobs that need to be completed; these jobs
 * are represented by distinct integers. You're also given a list of dependencies. A
 * dependency is represented as a pair of jobs where the first job is a
 * prerequisite of the second one. In other words, the second job depends on the
 * first one; it can only be completed once the first job is completed.
 *
 *
 * Write a function that takes in a list of jobs and a list of dependencies and
 * returns a list containing a valid order in which the given jobs can be
 * completed. If no such order exists, the function should return an empty array.
 *
 * O(j + d) time | O(j + d) space - where j is the number of jobs and d is the number of dependencies
 *
 */
public class TopologicalSort {
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph graph = createJobGraph(jobs, deps);
        return getOrderedJobs(graph);
    }

    private static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph graph = new JobGraph(jobs);
        for (Integer[] dep: deps) {
            graph.addPrereq(dep[1], dep[0]);
        }
        return graph;
    }

    private static List<Integer> getOrderedJobs(JobGraph graph) {
        List<Integer> orderedJobs = new ArrayList<>();
        List<JobNode> nodes = new ArrayList<>(graph.nodes);
        while (nodes.size() > 0){
            JobNode node = nodes.get(nodes.size() - 1);
            nodes.remove(nodes.size() - 1);
            boolean containsCycle = depthFirstTraverse(node, orderedJobs);
            if (containsCycle) {
                return new ArrayList<>();
            }
        }
        return orderedJobs;
    }

    private static boolean depthFirstTraverse(JobNode node, List<Integer> orderedJobs) {
        if (node.visited) {
            return false;
        }
        if (node.visiting) {
            return true;
        }
        node.visiting = true;
        for(JobNode prereqNode : node.prereqs) {
            boolean containsCycle = depthFirstTraverse(prereqNode, orderedJobs);
            if (containsCycle) {
                return true;
            }
        }
        node.visiting = false;
        node.visited = true;
        orderedJobs.add(node.job);
        return false;
    }

    static class JobGraph {
        List<JobNode> nodes;
        Map<Integer, JobNode> graph;

        public JobGraph(List<Integer> jobs) {
            nodes = new ArrayList<>();
            graph = new HashMap<>();
            for (Integer job : jobs) {
                addNode(job);
            }
        }

        private void addNode(Integer job) {
            graph.put(job, new JobNode(job));
            nodes.add(graph.get(job));
        }

        public void addPrereq(Integer job, Integer prereq) {
            JobNode jobNode = graph.get(job);
            JobNode jobNodePrereq = graph.get(prereq);
            jobNode.prereqs.add(jobNodePrereq);
        }
    }

    static class JobNode {
        public Integer job;
        public List<JobNode> prereqs;
        public boolean visited;
        public boolean visiting;

        public JobNode (Integer job) {
            this.job = job;
            prereqs = new ArrayList<>();
            visited = false;
            visiting = false;
        }
    }
}
