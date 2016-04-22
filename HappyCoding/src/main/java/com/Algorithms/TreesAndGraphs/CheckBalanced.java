package com.Algorithms.TreesAndGraphs;

import com.Utils.BinaryTreeNode;

/**
 * Implement a function to check if a binary tree is balanced. For the purposes
 * of this question, a balanced tree is defined to be a tree such that the heights 
 * of the two subtrees of any node never differ by more than one.
 * @author liushiyao
 *
 */
public class CheckBalanced {
    public boolean check(BinaryTreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }
    
    public int checkHeight(BinaryTreeNode root) {
        if (root == null) return -1;
        
        int leftHeight = checkHeight(root.left);
        int rightHeight = checkHeight(root.right);
        
        if (leftHeight == Integer.MIN_VALUE || rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE; 
        }
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
