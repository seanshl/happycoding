package com.Algorithms.TreesAndGraphs;

/**
 * Find first common ancestor of two nodes in a binary tree.
 * avoid storing additonal nodes in a data structure
 * @author liushiyao
 *
 */
public class FirstCommonAncestor {
    class Result {
        public BinaryTreeNode node;
        public boolean isAncestor;
        public Result(BinaryTreeNode n, boolean isAnc) {
            this.node = n;
            this.isAncestor = isAnc;
        }
    }
    
    public BinaryTreeNode commonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        Result r = commonAncHelper(root, p, q);
        if (r.isAncestor) {
            return r.node;
        }
        
        return null;
    }
    
    public Result commonAncHelper(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        if (root == null) return new Result(null, false);
        
        if (root == p && root == q) {
            return new Result (root, true);
        } 
        
        Result rx = commonAncHelper(root.left, p, q);
        if (rx.isAncestor) {
            return rx;
        }
        
        Result ry = commonAncHelper(root.right, p, q);
        if (ry.isAncestor) {
            return ry;
        }
        
        if (rx.node != null && ry.node != null) {
            return new Result(root, true);
        } else if (root == p || root == q) {
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(rx.node != null? rx.node : ry.node, false);
        }
    }
}
