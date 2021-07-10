package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthOfLongestSubstringTest {
    private LengthOfLongestSubstring sut;

    @BeforeEach
    public void setUp() {
        sut = new LengthOfLongestSubstring();
    }

    @Test
    public void lengthOfLongestSubstring() {
        assertEquals(3, sut.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(2, sut.lengthOfLongestSubstring("aab"));
        assertEquals(3, sut.lengthOfLongestSubstring("dvdf"));
        assertEquals(3, sut.lengthOfLongestSubstring("pwwkew"));
        assertEquals(3, sut.lengthOfLongestSubstring("ohomm"));
        assertEquals(6, sut.lengthOfLongestSubstring("asjrgapa"));
    }

    @Test
    public void lengthOfLongestSubstringApproach1() {
        assertEquals(3, sut.lengthOfLongestSubstringApproach1("abcabcbb"));
        assertEquals(2, sut.lengthOfLongestSubstringApproach1("aab"));
        assertEquals(3, sut.lengthOfLongestSubstringApproach1("dvdf"));
        assertEquals(3, sut.lengthOfLongestSubstringApproach1("pwwkew"));
        assertEquals(3, sut.lengthOfLongestSubstringApproach1("ohomm"));
        assertEquals(6, sut.lengthOfLongestSubstringApproach1("asjrgapa"));
    }

    @Test
    public void lengthOfLongestSubstringApproach2() {
        assertEquals(3, sut.lengthOfLongestSubstringApproach2("abcabcbb"));
        assertEquals(2, sut.lengthOfLongestSubstringApproach2("aab"));
        assertEquals(3, sut.lengthOfLongestSubstringApproach2("dvdf"));
        assertEquals(3, sut.lengthOfLongestSubstringApproach2("pwwkew"));
        assertEquals(3, sut.lengthOfLongestSubstringApproach2("ohomm"));
        assertEquals(6, sut.lengthOfLongestSubstringApproach2("asjrgapa"));
    }
}
