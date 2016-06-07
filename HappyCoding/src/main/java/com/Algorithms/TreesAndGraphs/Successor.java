package com.Algorithms.TreesAndGraphs;

import javax.swing.tree.TreeNode;

/**
 * Write an algo to find the "next" node of a given node in a binary
 * search tree. each node has a link to its parent.
 * @author liushiyao
 *
 */
//如果n有右子树，返回右子树的最左边的节点
//如果没有，向上倒，直到n成为某一个子树的左节点
public class Successor {
    public static BinaryTreeNode inorderSucc(BinaryTreeNode n) {
        if (n == null) return n;
        
        if (n.right != null) {
            return leftMostChild(n);
        } else {
            BinaryTreeNode q = n;
            BinaryTreeNode x = q.parent;
            
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            
            return x;
        }
    }
    
    @SuppressWarnings("rawtypes")
    public static BinaryTreeNode leftMostChild(BinaryTreeNode n) {
        if (n == null) return null;
        while (n.left != null) {
            n = n.left;
        }
        
        return n;
    }
}
