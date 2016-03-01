package com.test.LinkedListsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.Algorithms.LinkedLists.Node;
import com.Algorithms.LinkedLists.ReturnKthToLast;

public class ReturnKthToLastTest {
    
    private ReturnKthToLast test;
    private Node head;

    @Before
    public void onInit() {
        Node head = new Node(1);
        for (int i = 2; i < 6; i++) {
            head.appendToTail(i);
        }
        this.head = head;
        
        test = new ReturnKthToLast();
    }
    
    @Test
    public void test() {
        assertTrue(test.kthToLast(head, 1) == 5);
        assertTrue(test.kthToLast(head, 2) == 4);
        assertTrue(test.kthToLast(head, 3) == 3);
        assertTrue(test.kthToLast(head, 4) == 2);
        assertTrue(test.kthToLast(head, 5) == 1);
    }
}
