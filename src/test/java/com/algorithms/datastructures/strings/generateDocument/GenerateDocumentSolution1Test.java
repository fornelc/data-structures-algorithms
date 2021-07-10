package com.algorithms.datastructures.strings.generateDocument;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenerateDocumentSolution1Test {
    @Test
    public void TestCase1() {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        boolean expected = true;
        var actual = new GenerateDocumentSolution1().generateDocument(characters, document);
        assertTrue(expected == actual);
    }
}
