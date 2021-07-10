package com.algorithms.datastructures;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        String result = "";
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (result.indexOf(s.charAt(i)) == -1) {
                result = String.format("%s%s", result, s.charAt(i));
            } else {
                if (length < result.length()) {
                    length = result.length();
                }

                result = String.format("%s%s", result.substring(result.indexOf(s.charAt(i)) + 1), s.charAt(i));
            }
        }
        return length < result.length() ? result.length() : length;
    }

    /**
     * Suppose we have a function boolean allUnique(String substring)
     * which will return true if the characters in the substring are all unique, otherwise false.
     * We can iterate through all the possible substrings of the given string s
     * and call the function allUnique. If it turns out to be true,
     * then we update our answer of the maximum length of substring without duplicate characters.
     * Time O(n^3)
     * Space O(k) k is the size of the Set.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringApproach1(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }

        return ans;
    }

    /**
     *  We use HashSet to store the characters in current window [i, j)[i,j) (j = ij=i initially).
     *  Then we slide the index jj to the right. If it is not in the HashSet, we slide jj further.
     *  Doing so until s[j] is already in the HashSet.
     *  At this point, we found the maximum size of substrings
     *  without duplicate characters start with index ii.
     *  If we do this for all ii, we get our answer.
     *  Time: O(2n) = O(n). In the worst case each character will be visited twice by i and j.
     *  Space: O(k). k is the size of the Set.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringApproach2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }
}
