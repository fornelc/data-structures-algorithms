package com.algorithms.datastructures.stacks;

import java.util.*;

/**
 * Source: https://www.algoexpert.io/questions/Min%20Max%20Stack%20Construction
 */
public class MinMaxStackConstruction {
    static class MinMaxStack {
        List<Map<String, Integer>> minMaxStack = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();

        public int peek() {
            return stack.get(stack.size() - 1);
        }

        public int pop() {
            minMaxStack.remove(minMaxStack.size() - 1);
            return stack.remove(stack.size() - 1);
        }

        public void push(Integer number) {
            Map<String, Integer> newMinMax = new HashMap<>();
            newMinMax.put("min", number);
            newMinMax.put("max", number);
            if (minMaxStack.size() > 0) {
                Map<String, Integer> currentMinMax = minMaxStack.get(minMaxStack.size() - 1);
                newMinMax.put("min", Math.min(currentMinMax.get("min"), number));
                newMinMax.put("max", Math.max(currentMinMax.get("max"), number));
            }
            minMaxStack.add(newMinMax);
            stack.add(number);
        }

        public int getMin() {
            return minMaxStack.get(minMaxStack.size() - 1).get("min");
        }

        public int getMax() {
            return minMaxStack.get(minMaxStack.size() - 1).get("max");
        }
    }
}
