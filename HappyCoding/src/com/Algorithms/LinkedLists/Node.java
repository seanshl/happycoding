package com.Algorithms.LinkedLists;
/**
 * basic LinkedList Node for questions in this package.
 * @author shiyao
 *
 */
public class Node {
	public Node next = null;
	public int data;
	
	public Node(int d) {
		this.data = d;
	}
	
	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n= this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	@SuppressWarnings("unused")
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (this == null) {
			return "";
		} 
		sb.append(this.data);
		Node n = this;
		
		while (n.next != null) {
			sb.append(" -> ");
			sb.append(n.next.data);
			n = n.next;
		}
		
		return sb.toString();
	}
	
	public boolean equalsTo(Node other) {
		if (this == null && other == null) {
			return true;
		} else if (this == null || other == null) {
			return false;
		} else if (this.data != other.data) {
			return false;
		} else if (this.next == null && other.next == null ) {
			return true;
		} else if (this.next == null || other.next == null) {
			return false;
		} else {
			return this.next.equalsTo(other.next);
		}
		
	}

	
	
	
	
}
