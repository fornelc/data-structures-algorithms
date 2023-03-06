package com.algorithms.datastructures.topKElement;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Map.Entry<Integer, List<Integer>>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int dist = x * x + y * y;

            maxHeap.offer(Map.entry(dist, Arrays.asList(x, y)));

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] output = new int[k][];
        int i = 0;

        while(!maxHeap.isEmpty()) {
            List<Integer> point = maxHeap.poll().getValue();
            output[i] = new int[] {point.get(0), point.get(1)};

            i++;
        }

        return output;
    }
}
