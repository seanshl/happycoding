package com.test.LinkedListsTest;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

import com.Algorithms.LinkedLists.Node;
import com.Algorithms.LinkedLists.RemoveDups;

public class RemoveDupsTest {
	private Node head1;
	private Node head2;
	private Node head3;
	private Node head4;
	
	private RemoveDups test = new RemoveDups();

	public void resetNodes() {
		//head1 = null;
		head1 = null;
		
		head2 = new Node(1);
		for (int i = 2; i < 100; i++) {
			head2.appendToTail(i);
		}
		
		head3 = new Node(1);
		for (int i = 2; i < 100; i++) {
			head3.appendToTail(i);
			head3.appendToTail(i);
		}
		
		head4 = new Node(1);
		
		
	}
	@Test 
	public void testEqualsTo() {
		head1 = null;
		head2 = new Node(1);
		head3 = new Node(1); head3.appendToTail(2);
		head4 = new Node(1); head4.appendToTail(2); head4.appendToTail(3);
		Node head5 = new Node(1); head5.appendToTail(2); head5.appendToTail(4);
		Node head6 = new Node(1); head6.appendToTail(2); head6.appendToTail(4);
		
		
		assertFalse(head2.equalsTo(head1));
		assertFalse(head2.equalsTo(head3));
		assertFalse(head3.equalsTo(head4));
		assertFalse(head4.equalsTo(head5));
		assertTrue(head5.equalsTo(head6));
	}

	@Test
	public void testWithSet() {
		resetNodes();
		test.removeWithSet(head1);
		test.removeWithSet(head2);
		test.removeWithSet(head3);
		test.removeWithSet(head4);
		
		assertTrue(head1 == null);
		System.out.println(head3.toString());
		assertTrue(head4.equalsTo(new Node(1)));
		
		
		assertTrue(head3.equalsTo(head2));
		
	}

}
