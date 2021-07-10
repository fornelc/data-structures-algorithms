package com.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplementBase10Test {

    private ComplementBase10 sut;

    @BeforeEach
    public void setUp() {
        sut = new ComplementBase10();
    }

    @Test
    public void bitwiseComplement() {
        assertEquals(sut.bitwiseComplement(5), 2);
    }

    @Test
    public void bitwiseComplement2() {
        assertEquals(sut.bitwiseComplement2(8), 7);
    }
}
