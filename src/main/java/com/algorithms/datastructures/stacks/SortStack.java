package com.algorithms.datastructures.stacks;

import java.util.ArrayList;

public class SortStack {
    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }

        Integer top = stack.remove(stack.size() - 1);

        sortStack(stack);

        addIntegerSorted(stack, top);

        return stack;
    }

    private ArrayList<Integer> addIntegerSorted(ArrayList<Integer> stack, Integer value) {
        if (stack.isEmpty() || stack.get(stack.size() - 1) <= value) {
            stack.add(value);
            return stack;
        }

        Integer top = stack.remove(stack.size() - 1);

        addIntegerSorted(stack, value);

        stack.add(top);

        return stack;
    }
}
