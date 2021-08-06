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
public class TopologicalSortSolution2 {
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph jobGraph = createJobGraph(jobs, deps);
        return getOrderedJobs(jobGraph);
    }

    private static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph graph = new JobGraph(jobs);
        for (Integer[] dep: deps) {
            graph.addDep(dep[0], dep[1]);
        }
        return graph;
    }

    private static List<Integer> getOrderedJobs(JobGraph graph) {
        List<Integer> orderedJobs = new ArrayList<>();
        List<JobNode> nodesWithNoPrereqs = new ArrayList<>();
        buildNodesWithNoPrereqsList(graph, nodesWithNoPrereqs);
        addInOrderedJobsListNodesWithNoPrereq(orderedJobs, nodesWithNoPrereqs);

        return hasCycle(graph) ? new ArrayList<>() : orderedJobs;
    }

    private static boolean hasCycle(JobGraph graph) {
        boolean hasCycle = false;
        for (JobNode node : graph.nodes) {
            if (node.numOfPrereqs > 0) {
                hasCycle = true;
                break;
            }
        }
        return hasCycle;
    }

    private static void addInOrderedJobsListNodesWithNoPrereq(List<Integer> orderedJobs, List<JobNode> nodesWithNoPrereqs) {
        while (nodesWithNoPrereqs.size() != 0) {
            JobNode node = nodesWithNoPrereqs.get(nodesWithNoPrereqs.size() - 1);
            nodesWithNoPrereqs.remove(nodesWithNoPrereqs.size() - 1);
            orderedJobs.add(node.job);
            removeDependencies(node, nodesWithNoPrereqs);
        }
    }

    private static void buildNodesWithNoPrereqsList(JobGraph graph, List<JobNode> nodesWithNoPrereqs) {
        for (JobNode jobNode : graph.nodes) {
            if (jobNode.numOfPrereqs == 0) {
                nodesWithNoPrereqs.add(jobNode);
            }
        }
    }

    private static void removeDependencies(JobNode node, List<JobNode> nodesWithNoPrereqs) {
        while(node.deps.size() != 0) {
            JobNode dep = node.deps.get(node.deps.size() - 1);
            node.deps.remove(node.deps.size() - 1);
            dep.numOfPrereqs--;
            if (dep.numOfPrereqs == 0) {
                nodesWithNoPrereqs.add(dep);
            }
        }
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

        public void addDep(Integer job, Integer dep) {
            JobNode jobNode = graph.get(job);
            JobNode jobNodeDep = graph.get(dep);
            jobNode.deps.add(jobNodeDep);
            jobNodeDep.numOfPrereqs++;
        }
    }

    static class JobNode {
        public Integer job;
        public List<JobNode> deps;
        public int numOfPrereqs;

        public JobNode (Integer job) {
            this.job = job;
            deps = new ArrayList<>();
            numOfPrereqs = 0;
        }
    }
}
