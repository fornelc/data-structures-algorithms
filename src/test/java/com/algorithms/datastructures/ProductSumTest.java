package com.algorithms.datastructures;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductSumTest {
    private ProductSum sut;

    @BeforeEach
    public void setUp() {
        sut = new ProductSum();
    }

    @Test
    public void productSum_returnProductSum() {
        assertEquals(12, sut.productSum(buildArray()));
    }

    private List<Object> buildArray() {
        List<Object> objects = new ArrayList<>();
        objects.add(5);
        objects.add(2);
        List<Integer> subArray = new ArrayList<>();
        subArray.add(7);
        subArray.add(-1);
        objects.add(subArray);
        objects.add(3);
        List<Object> subArray2 = new ArrayList<>();
        subArray2.add(6);
        List<Object> subArray3 = new ArrayList<>();
        subArray3.add(-13);
        subArray3.add(8);
        subArray2.add(subArray3);
        subArray2.add(4);
        objects.add(subArray2);

        return objects;
    }
}
