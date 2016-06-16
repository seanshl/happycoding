package com.Algorithms.TreesAndGraphs;

/**
 * T1 and T2 are two very large binary Trees, with T much bigger than T2 . Check if T2 is a 
 * subtree of T1.
 * A tree T2 is a subtree of T1 if there exist a node n in T1 such taht the subtree of n is
 * identical to T2. That is , ifyou cut off the tree at node n, the two trees would be 
 * identical
 * @author liushiyao
 *
 */
public class CheckSubtree {
    public boolean containsTree(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t2 == null) return true;
        return subTree(t1, t2);
    }
    
    private boolean subTree(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t1 == null) {
            return false;
        } else if (t1.value == t2.value && identical(t1, t2)) {
            return true;
        }
        
        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }
    
    private boolean identical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null) return false;
        
        if (root1.value  != root2.value) return false;
        return identical(root1.left, root2.left) && identical(root1.right, root2.right);
    }
    
}
