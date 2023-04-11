package com.algorithms.datastructures.stacks;

import java.util.Stack;

public class RemoveKDigits {


    public String removeKdigits(String num, int k) {
        final Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            final Character number = num.charAt(i);
            while(!stack.isEmpty() && k != 0 && stack.peek() > number) {
                stack.pop();
                k--;
            }

            stack.push(number);
        }

        while (k != 0) {
            stack.pop();
            k--;
        }

        final StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        String result = sb.reverse().toString();

        int i = 0;
        while (i < result.length() && result.charAt(i) == '0') {
            i++;
        }

        result = result.substring(i);

        return result.isEmpty() ? "0" : result;
    }
}
