package com.algorithms.datastructures.graphs;

/**
 * Exercise: https://www.algoexpert.io/questions/Youngest%20Common%20Ancestor
 *
 * How to solve:
 *
 * You could try to simultaneously iterate through the ancestors of both input descendants until you find a common ancestor;
 * however, if one of the descendants has more ancestors than the other (i.e., is lower in the ancestral tree),
 * you won't find the youngest common ancestor.
 *
 * So start by finding the two input descendants' depths in the ancestral tree.
 * If one of them is deeper, iterate up through its ancestors until you reach the depth of the higher descendant.
 * Then, iterate through both descendants' ancestors in tandem until you find the first common ancestor.
 * Note that at this point,
 * one of the descendants will be the ancestor of the lower descendant that is at the same level as the higher descendant.
 * So that would mean that the higher descendant would be the youngest common ancestor.
 * As in the prompt of the problem says that a descendant is considered its own ancestor.
 *
 * Space & Time Complexity:
 * O(d) time | O(1) space -
 *
 * O(d) time: where d is the depth of the lowest descendant,
 * because that's gonna be the longest iteration that we're gonna have to do.
 *
 * O(1) space: because we can write this algorithm iteratively with just a few while loops,
 * and we're not gonna need any extra space, no extra calls on the call stack with recursion,
 * no need to store anything beyond a couple of variables, so constant space.
 */
public class YoungestCommonAncestor {
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        int depthOne = getDescendantDepth(descendantOne, topAncestor);
        int depthTwo = getDescendantDepth(descendantTwo, topAncestor);

        if (depthOne > depthTwo) {
            topAncestor = retrieveTopAncestor(descendantOne, descendantTwo, depthOne - depthTwo);
        } else {
            topAncestor = retrieveTopAncestor(descendantTwo, descendantOne, depthTwo - depthOne);
        }

        return topAncestor;
    }

    private static AncestralTree retrieveTopAncestor(AncestralTree descendantOne, AncestralTree descendantTwo, int depth) {
        while (depth > 0) {
            descendantOne = descendantOne.ancestor;
            depth--;
        }
        while(descendantOne != descendantTwo) {
            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }
        return descendantOne;
    }

    private static int getDescendantDepth(AncestralTree descendantOne, AncestralTree topAncestor) {
        int depth = 0;
        while (topAncestor.name != descendantOne.name) {
            descendantOne = descendantOne.ancestor;
            depth++;
        }
        return depth;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
