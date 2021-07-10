package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LetterCombinationsPhoneNumberTest {
    private LetterCombinationsPhoneNumber sut;

    @BeforeEach
    public void setUp() {
        sut = new LetterCombinationsPhoneNumber();
    }

    @Test
    public void letterCombinations() {
        List<String> result = sut.letterCombinations("23");
        assertEquals("ad", result.get(0));
        assertEquals("ae", result.get(1));
        assertEquals("af", result.get(2));
        assertEquals("bd", result.get(3));
    }
}
