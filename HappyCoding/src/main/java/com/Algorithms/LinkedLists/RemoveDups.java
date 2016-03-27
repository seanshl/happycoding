package com.Algorithms.LinkedLists;

import java.util.HashSet;

import com.Utils.Node;

/**
 * write code to remove duplicates from an unsorted linked list.
 * @author asus
 *
 */
public class RemoveDups {
	
	public void removeWithSet(Node head) {
		if (head == null) return;
		
		HashSet <Integer> set = new HashSet<Integer> ();
		Node previous = null;
		while (head != null) {
			if (set.contains(head.data)) {
				previous.next = head.next;
			} else {
				set.add(head.data);
				previous = head;
			}
			head = head.next;
		}		
	
	}
	
}
