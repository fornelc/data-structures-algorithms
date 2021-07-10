package com.algorithms.datastructures.strings;

public class RunLengthEncoding {

    /**
     * https://www.algoexpert.io/questions/Run-Length%20Encoding
     *
     * To solve it we could do something like string+="4A"
     * but this is not good, because string is immutable data type.
     * So when we perform a concatenation, we have to rebuild the entire string.
     * So whatever the length of the string is, we're gonna have to perform many operations
     * plus the other string that we're gonna be adding to it, to create this new string.
     * So that's known as an O(n) operation.
     * So if we're going to loop through all of the characters of the string passed as parameter,
     * that is already an O(n) operation. Now, if we're going to perform a concatenate operation every single
     * time we loop through a string character, then what we would get is an O(n^2) time algorithm.
     *
     * Time O(n) | Space O(n)
     *
     * Explanation of the space: Imagine our worst case that would be ABCDEF,
     * then we would need to add two times the number of characters in the result string
     * 1A1B1C1D1E1F, so we would end up having O(2n) space, where n represents the length of our input string.
     * But since we are looking at big o notation, I can simply remove the constant from in front of this n.
     * And just say that the space complexity is O(n). And remember that as we get to a very large value of n,
     * that two that's before it becomes less and less significant, and we can remove it from the big O notation.
     *
     * Explanation of the time: We are going to iterate the loop n times, and n is the length of the input string,
     * and inside of the loop we will be doing constant time operations. So the complexity time is O(n) in the for loop.
     * But in the return part of the function, we are converting the StringBuilder to String, and that takes
     * O(n) time. So if we calculate the loop O(n) time plus the string convert O(n) time, it gives us 2O(n) time complexity.
     * And then we can just simply get rid of the constants, because again we do not care about the constants,
     * when we're doing a space time complexity analysis, and that gives us O(n) time complexity.
     * @param string
     * @return
     */
    public static String runLengthEncoding(String string) {
        int counter = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) != string.charAt(i - 1) || counter == 9) {
                builder.append(counter);
                builder.append(string.charAt(i-1));
                counter = 0;
            }
            counter++;
        }
        builder.append(counter);
        builder.append(string.charAt(string.length()-1));
        return builder.toString();
    }
}
