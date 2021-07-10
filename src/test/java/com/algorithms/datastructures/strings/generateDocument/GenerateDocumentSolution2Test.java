package com.algorithms.datastructures.strings.generateDocument;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenerateDocumentSolution2Test {
    @Test
    public void TestCase1() {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        boolean expected = true;
        var actual = new GenerateDocumentSolution2().generateDocument(characters, document);
        assertTrue(expected == actual);
    }
}
