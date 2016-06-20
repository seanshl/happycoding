package com.Algorithms.TreesAndGraphs;

public class BST <Key extends Comparable, Value>{
    public BinaryTreeNode root;
    
    public void put(Key key, Value val) {
        this.root = putHelper(this.root, key, val);
    }
    
    @SuppressWarnings("unchecked")
    private BinaryTreeNode putHelper(BinaryTreeNode node, Key key, Value value) {
        if (node == null) return new BinaryTreeNode(key, value);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = putHelper(node.left, key, value);
        } else if (cmp > 0) {
            node.right = putHelper(node.right, key, value);
        } else {
            node.value = value;
        }
        
        return node;
    }
    
    /**
     * compare target with current node, if smaller, go left
     * if bigger, go right
     * if null return null
     * @param key
     * @return
     */
    public Value get(Key key) {
        BinaryTreeNode node = this.root;
        
        while(node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) node = node.left;
            else if (cmp > 0) node = node.right;
            else return (Value) node.value;
        }
        
        return null;
    }
    
    public void delete(Key key) {
        
    }

}
