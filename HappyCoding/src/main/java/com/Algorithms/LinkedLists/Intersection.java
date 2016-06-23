package com.Algorithms.LinkedLists;

import com.Utils.Node;

public class Intersection {
    private class Result {
        public Node tail;
        public int size;
        public Result(Node tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }
    
    Result getTailAndSize(Node l) {
        if (l == null) return null;
        int size = 1;
        Node current = l;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        
        return new Result(current, size);
    }
    
    Node getKthNode(Node head, int k) {
        Node current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }
    
    Node findIntersection(Node l1, Node l2) {
        if (l1 == null || l2 == null) return null;
        
        Result r1 = getTailAndSize(l1);
        Result r2 = getTailAndSize(l2);
        
        if (r1.tail != r2.tail) return null;
        
        Node shorter = r1.size < r2.size? l1 : l2;
        Node longer = r1.size < r2.size? l2 : l1;
        
        longer = this.getKthNode(longer,  Math.abs(r1.size - r2.size));
        
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        
        return longer;
        
    }
}
