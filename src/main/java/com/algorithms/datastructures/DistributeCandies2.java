package com.algorithms.datastructures;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DistributeCandies2 {
    public int solution(int[] T) {
        Set<Integer> targetSet = new HashSet<>(IntStream.of(T).boxed().collect(Collectors.toList()));
        return Math.min(targetSet.size(), T.length/2);
    }
}
