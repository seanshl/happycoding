package com.Algorithms.StacksAndQueues;

import java.util.Stack;
/**
 * How would you design a stack which, in addition to push and pop, 
 * has function min which returns the minimum element? push, pop, min
 * should all operate in O(1) time.
 * @author asus
 *
 */
public class StackMin2 extends Stack<Integer>{
	Stack<Integer> minStack = new Stack<Integer> ();
	public void push(int x) {
		if (super.isEmpty()) {
			minStack.push(x);
		} else {
			if (minStack.peek() > x) {
				minStack.push(x);
			} else {
				minStack.push(minStack.peek());
			}
		}
		
		super.push(x);
	}
	
	public Integer pop() {
		if (super.isEmpty()) {
			return null;
		}
		minStack.pop();
		return super.pop();
	}
	
	public Integer min() {
		if (super.isEmpty()) {
			return null;
		}
		return minStack.peek();
	}

}
