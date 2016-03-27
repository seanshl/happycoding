package com.Algorithms.LinkedLists;

import com.Utils.Node;

/**
 * Implement an algorithm to delete a node in the middle(i.e, any node but the first
 * and last node, not necessarily the exact middle) of a singly linked list,
 * given only access to that node.
 * eg.
 * Input: the node c from the linked list a->b->c->d->e->f
 * result: nothing is returned, but the new linked list look like a->b->d->e->
 * @author liushiyao
 *
 */
public class DeleteMiddleNode {
    
    public static void deleteMiddle(Node c) {
        c.data = c.next.data;
        c.next = c.next.next;
    }
}
