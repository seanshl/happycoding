package com.Algorithms.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

import com.Utils.BinaryTreeNode;

/**
 * Given a binary tree, design an algo which creates a linked list of all the nodes
 * at each depth(eg, if you have a tree with depth D, you 'll have D linked lists).
 * @author liushiyao
 *
 */
public class ListOfDepths {
    /**
     * The thought of BFS. Why use this method?
     * Reason (1). It's similar to BFS
     * @param head
     * @return
     */
    public ArrayList<LinkedList<BinaryTreeNode>> createLists2(BinaryTreeNode head) {
        ArrayList<LinkedList<BinaryTreeNode>>list = new ArrayList<LinkedList<BinaryTreeNode>> ();
        
        LinkedList<BinaryTreeNode> currentLevel = new LinkedList<BinaryTreeNode> ();
        
        if (head != null) {
            currentLevel.add(head);
        }
        
        while(!currentLevel.isEmpty()) {
            list.add(currentLevel);
            LinkedList<BinaryTreeNode> parentLevel = currentLevel;
            
            currentLevel = new LinkedList<BinaryTreeNode> ();
            for (BinaryTreeNode parentNode: parentLevel) {
                if (parentNode.left != null) {
                    currentLevel.add(parentNode.left);
                } 
                if (parentNode.right != null) {
                    currentLevel.add(parentNode.right);
                }
            }
        }
        
        return list;
    }
    
    
    ArrayList<LinkedList<Integer>> list;
    public ArrayList<LinkedList<Integer>> createLists(BinaryTreeNode head) {
        list = new ArrayList<LinkedList<Integer>> ();
        
        traverse(head, 0);
        
        return list;
    }
    
    private void traverse(BinaryTreeNode node, int depth) {
        if (node == null) {
            return;
        }
        
        if (list.size() == depth) {
            list.get(depth).add(node.value);
        } else {
            LinkedList<Integer> level = new LinkedList<Integer> ();
            level.add(node.value);
            
            list.add(level);
        }
        
        traverse(node.left, depth + 1);
        traverse(node.right, depth + 1);
    }
}
