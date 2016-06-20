package com.Algorithms.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A binary search tree was created by traversing through an array from left 
 * to right and inserting each element.  Given a binary search tree with distinct
 * elements, print all possible arrays that could have led to this tree.
 * @author liushiyao
 *
 */
public class BSTSequence {
    public ArrayList<LinkedList<Integer>> sequence(BinaryTreeNode <Integer, Integer> root) {
        ArrayList<LinkedList<Integer>> res = new ArrayList<>();
        
        if (root == null) return res;
        
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add((Integer) root.value);
        
        ArrayList<LinkedList<Integer>> leftSeq = sequence(root.left);
        ArrayList<LinkedList<Integer>> rightSeq = sequence(root.right);
        
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved =
                        new ArrayList<LinkedList<Integer>>();
                this.weaveLists(left, right, weaved, prefix);
                res.addAll(weaved);
            }
        }
        return res;
    }
    
    private void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
            ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if (first.size() == 0 || second.size() == 0) {
            @SuppressWarnings("unchecked")
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            
            results.add(result);
        }
        
        int headFirst = first.removeLast();
        prefix.add(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);
        
        int headSecond = second.removeLast();
        prefix.add(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }
}
