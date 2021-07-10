package com.algorithms.datastructures.dynamicProgramming.longestCommonSubsequence;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequenceSolution1 {
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        List<List<List<Character>>> lcs = new ArrayList<>();
        for (int i = 0; i < str1.length() + 1; i++) {
            lcs.add(new ArrayList<>());
            for (int j = 0; j < str2.length() + 1; j++) {
                lcs.get(i).add(new ArrayList<>());
            }
        }
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // We create copy by invoking new ArrayList,
                    // as assigning it directly without new ArrayList,
                    // when calling .add method, the character is added in the current element
                    // and in each element of the previous row
                    List<Character> copy = new ArrayList<>(lcs.get(i-1).get(j-1));
                    lcs.get(i).set(j, copy);
                    lcs.get(i).get(j).add(str1.charAt(i - 1));
                } else {
                    if (lcs.get(i - 1).get(j).size() > lcs.get(i).get(j - 1).size()) {
                        lcs.get(i).set(j, lcs.get(i - 1).get(j));
                    } else {
                        lcs.get(i).set(j, lcs.get(i).get(j - 1));
                    }
                }
            }
        }

        return lcs.get(str1.length()).get(str2.length());
    }
}