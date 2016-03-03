package com.Algorithms.TreesAndGraphs;

/**
 * Given a sorted(increasing order) array with unique integer elements, write an 
 * algorithm to create a binary search tree with minimal height.
 * @author liushiyao
 *
 */
public class MinimalTree {
    
    public static BinaryTreeNode createMinimalTree(int arr[]) {
        return createMinimalTree(arr, 0, arr.length - 1);
    }
    
    public static BinaryTreeNode createMinimalTree(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = (start + end) / 2;
        BinaryTreeNode n = new BinaryTreeNode(arr[mid]);
        n.left = createMinimalTree(arr, start, mid - 1);
        n.right = createMinimalTree(arr, mid + 1, end);
        
        return n;
    }

}
