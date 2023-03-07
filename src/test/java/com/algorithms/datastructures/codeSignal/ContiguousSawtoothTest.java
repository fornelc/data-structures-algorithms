package com.algorithms.datastructures.codeSignal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContiguousSawtoothTest {

        @Test
        public void testSolution1() {
                // given
                int[] arr = {9, 8, 7, 6, 5};
                int expected = 4;

                // when
                int actual = new ContiguousSawtooth().countingContiguousSawtooth(arr);

                // then
                assertEquals(expected, actual);
        }

        @Test
        public void testSolution2() {
                // given
                int[] arr = {1, 2, 1, 2, 1};
                int expected = 10;

                // when
                int actual = new ContiguousSawtooth().countingContiguousSawtooth(arr);

                // then
                assertEquals(expected, actual);
        }
}
