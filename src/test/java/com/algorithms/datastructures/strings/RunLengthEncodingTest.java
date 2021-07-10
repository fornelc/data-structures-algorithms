package com.algorithms.datastructures.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunLengthEncodingTest {
    @Test
    public void runLengthEncoding_returnString() {
        assertEquals("9A4A2B4C2D", RunLengthEncoding.runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
    }

}
