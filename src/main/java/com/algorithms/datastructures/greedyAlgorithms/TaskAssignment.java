package com.algorithms.datastructures.greedyAlgorithms;

import java.util.*;

/**
 * Source: https://www.algoexpert.io/questions/Task%20Assignment
 *
 * How to Solve:
 * Start by considering which pairs of tasks will lead to the LONGEST possible time to complete all tasks.
 *
 * The amount of time it'll take to complete all tasks will be dictated
 * by the pair of tasks that has the longest total duration.
 * This means that you'll want to avoid pairing long tasks together.
 *
 * Since the pair of tasks with the longest total duration is the time it takes for us to finish all tasks,
 * we want to minimize this pair's duration.
 * To do this, we can simply pair the shortest-duration task with the longest-duration task
 * and repeat the process with all other tasks.
 *
 * Start by sorting the tasks array in ascending order.
 * Then, pair the shortest-duration task with the longest-duration task,
 * and add that pair to some output array.
 * Repeat this process until you've paired all tasks.
 * This will lead to an optimal pairing,
 * because your pair of tasks with the longest duration will have the shortest duration that it can possibly have.
 *
 * Space & Time complexity
 * O(nlog(n)) time | O(n) space - where n is the number of tasks
 *
 * O(n) space because the paired task list we create as a result,
 * and as well as the auxiliary data structure that stores a mapping of indices and tasks.
 *
 * O(nlog(n)) time because we need to sort the tasks input
 * and the other operations in our solution are going to run in O(n) time,
 * so the total time complexity of our algorithm will be O(nlog(n)).
 */
public class TaskAssignment {
    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        ArrayList<ArrayList<Integer>> taskAssignments = new ArrayList<>();

        Map<Integer, ArrayList<Integer>> tasksMap = getTasksMap(tasks);

        ArrayList<Integer> sortedTasks = tasks;
        Collections.sort(sortedTasks);

        for (int i = 0; i < k; i++) {
            int task1Duration = sortedTasks.get(i);
            ArrayList<Integer> indicesWithTaskDuration = tasksMap.get(task1Duration);
            int task1Index = indicesWithTaskDuration.remove(indicesWithTaskDuration.size() - 1);

            int task2SortedIndex = sortedTasks.size() - i - 1;
            int task2Duration = sortedTasks.get(task2SortedIndex);
            ArrayList<Integer> indicesWithTask2Duration = tasksMap.get(task2Duration);
            int task2Index = indicesWithTask2Duration.remove(indicesWithTask2Duration.size() - 1);

            ArrayList<Integer> pairedTask = new ArrayList<>();
            pairedTask.add(task1Index);
            pairedTask.add(task2Index);
            taskAssignments.add(pairedTask);
        }

        return taskAssignments;
    }

    private Map getTasksMap(final ArrayList<Integer> tasks) {
        final Map<Integer, List> taskMap = new HashMap();
        for (int i = 0; i < tasks.size(); i++) {
            List<Integer> taskList;
            if (taskMap.containsKey(tasks.get(i))) {
                taskMap.get(tasks.get(i)).add(i);
            } else {
                taskList = new ArrayList<>();
                taskList.add(i);
                taskMap.put(tasks.get(i), taskList);
            }
        }

        return taskMap;
    }
}
