package com.algorithms.datastructures.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     * Solution: https://leetcode.com/problems/generate-parentheses/solution/
     * @param ans
     * @param cur
     * @param open
     * @param close
     * @param max
     */
    private void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}
