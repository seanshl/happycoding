package com.Algorithms.LinkedLists;

import com.Utils.Node;

public class SumLists {
    
    public Node sum(Node a, Node b) {
        return sum(0, a, b);
    }
    
    public Node sum (int carry, Node a, Node b) {
        if (a == null && b == null) return null;
        
        Node result = new Node();
        int value = carry;
        
        Node nextA = null;
        Node nextB = null;
        
        if (a != null) {
            value += a.data;
            nextA = a.next;
        }
        if (b != null) {
            value += b.data;
            nextB = b.next;
        }
        
        result.data = value % 10;
        carry = value / 10;
        
        result.next = sum(carry, 
                a == null? null : a.next, 
                b == null? null : b.next);
        
        return result;
    }
    
    public static void main(String []args) {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);
        
        Node head2 = new Node(3);
        head2.appendToTail(2);
        
        SumLists test = new SumLists();
        
        System.out.println(test.sum(head,  head2).toString());
    }
}
