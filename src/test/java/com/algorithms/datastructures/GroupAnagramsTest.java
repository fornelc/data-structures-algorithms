package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupAnagramsTest {
    private GroupAnagrams sut;

    @BeforeEach
    public void setUp() {
        sut = new GroupAnagrams();
    }

    @Test
    public void groupAnagrams() {
        List<List<String>> expected = Arrays.asList(Arrays.asList(""));
        String[] strings = new String[] {""};
        assertEquals(expected, sut.groupAnagrams(strings));
        expected = Arrays.asList(Arrays.asList("a"));
        strings = new String[] {"a"};
        assertEquals(expected, sut.groupAnagrams(strings));
        expected = Arrays.asList(Arrays.asList("eat", "tea", "ate"), Arrays.asList("bat"), Arrays.asList("tan", "nat"));
        strings = new String[] {"eat","tea","tan","ate","nat","bat"};
        assertEquals(expected, sut.groupAnagrams(strings));
    }
}
