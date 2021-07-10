package com.algorithms.datastructures.graphs;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class YoungestCommonAncestorTest {
    public HashMap<Character, YoungestCommonAncestor.AncestralTree> getTrees() {
        var trees = new HashMap<Character, YoungestCommonAncestor.AncestralTree>();
        var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
            trees.put(a, new YoungestCommonAncestor.AncestralTree(a));
        }

        trees
                .get('A')
                .addAsAncestor(
                        new YoungestCommonAncestor.AncestralTree[] {
                                trees.get('B'), trees.get('C'), trees.get('D'), trees.get('E'), trees.get('F')
                        });
        return trees;
    }

    @Test
    public void TestCase1() {
        var trees = getTrees();
        trees.get('A').addAsAncestor(new YoungestCommonAncestor.AncestralTree[] {trees.get('B'), trees.get('C')});
        trees.get('B').addAsAncestor(new YoungestCommonAncestor.AncestralTree[] {trees.get('D'), trees.get('E')});
        trees.get('D').addAsAncestor(new YoungestCommonAncestor.AncestralTree[] {trees.get('H'), trees.get('I')});
        trees.get('C').addAsAncestor(new YoungestCommonAncestor.AncestralTree[] {trees.get('F'), trees.get('G')});

        var yca = YoungestCommonAncestor.getYoungestCommonAncestor(trees.get('A'), trees.get('E'), trees.get('I'));
        assertTrue(yca == trees.get('B'));
    }
}
