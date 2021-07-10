package com.algorithms.datastructures;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    // Space O(n) | Time O(c^t) -> n is the size of the result array, and the time soluction is candidates raised to target
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(list));
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }
}
