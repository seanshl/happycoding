package com.beaverbay.prototype;
import java.util.List;

/**
 * Node represents a node object in the Notebook hierarchy.
 * For example, a node book has such hierarchy.
 * 
 * *1. Supervised Learning
 * *     ---> 1.2 Perceptron Algorithm
 * *          ---> (A). Definition
 * *          ---> (B). Properties
 * *               --->a. Time complexity 
 * **                      this algorithm apply O(n) time complexity.
 * 
 * Each of the above with double asterisks is a node in this notebook hierarchy. 
 * 
 * @author liushiyao
 *
 */
public abstract class Node {
    // To identify this node from database
    private long id;
    // To find the parent node, the notebook is a tree.
    private Node parentNode;
    
    private List<Node> childrenNode;
    
    private Level level;
    
    private String topic;
    
    private List<Item> items;
    
}
