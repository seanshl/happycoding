package com.Algorithms.TreesAndGraphs;

/**
 * check if a binary tree is a binary search tree
 * @author liushiyao
 *
 */
public class ValidateBST {
    Integer lastPrinted = null;
    public boolean checkBST(BinaryTreeNode<Integer, Integer> root) {
        if (root == null) return true;
        if (!checkBST(root.left)) return false;
        
        if (lastPrinted != null && root.value <= lastPrinted) {
            return false;
        } 
        lastPrinted = root.value;
        
        if (!checkBST(root.right)) {
            return false;
        }
        
        return true;
    }
    
    public boolean checkBST2(BinaryTreeNode<Integer, Integer> node, Integer min, Integer max) {
        if (node == null) return true;
        
        if ((min != null && node.value <= min) || (max != null && node.value > max)) {
            return false;
        }
        
        if (!checkBST2(node.left, min, node.value) || !checkBST2(node.right, node.value, max)) {
            return false;
        }
        
        return true;
    }
    
}
