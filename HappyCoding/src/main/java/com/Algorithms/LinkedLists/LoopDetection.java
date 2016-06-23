package com.Algorithms.LinkedLists;

import com.Utils.Node;

public class LoopDetection {

    public Node detectCycle(Node head) {
        if (head == null || head.next == null) return null;
            
        Node fast = head;
        Node slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow) {
                break;
            }
        }
        
        if (fast != null && fast.next != null) {
            Node newRunner = head;
            while(true) {
                if (newRunner == slow) {
                    return newRunner;
                }
                newRunner = newRunner.next;
                slow = slow.next;
            }
        }
        
        return null;
    }
}
