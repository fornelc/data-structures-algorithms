package com.algorithms.datastructures.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalancedBracketsTest {
    @Test
    public void TestCase1() {
        String input = "([])(){}(())()()";
        assertTrue(BalancedBrackets.balancedBrackets(input));
    }
}
