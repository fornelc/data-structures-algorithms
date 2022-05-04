package com.algorithms.datastructures.searching;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class QuickselectTest {
  @Test
  public void TestCase1() {
    assertTrue(Quickselect.quickselect(new int[] {8, 5, 2, 9, 7, 6, 3}, 3) == 5);
  }
}
