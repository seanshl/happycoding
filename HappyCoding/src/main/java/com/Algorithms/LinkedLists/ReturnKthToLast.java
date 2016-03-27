package com.Algorithms.LinkedLists;

import com.Utils.Node;

/**
 * Implement an algorithm to find the kth to last element of singly linked list.
 * @author liushiyao
 *
 */
public class ReturnKthToLast {
    private int count = 0;;
    private boolean getResult = false;
    
    public void clear() {
        this.count = 0;
        this.getResult = false;
    }

    public Integer kthToLast(Node head, int k) {
        if (head == null) {
            return null;
        }
        this.count = k;
        this.getResult = false;

        return kthToLast(head);
    }

    public Integer kthToLast(Node node) {
        if (node.next == null) {
            return node.data;
        }
        Integer returned = kthToLast(node.next);
        count--;
        
        if (!getResult) {
            if (count == 0) {
                getResult = true;
                return returned;
            }
            return node.data;
        } else {
            return returned;
        }      
    }

    public void setCount(int k) {
        this.count = k;
    }
}
