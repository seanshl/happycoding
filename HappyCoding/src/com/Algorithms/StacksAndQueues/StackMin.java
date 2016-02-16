package com.Algorithms.StacksAndQueues;

import java.util.Stack;

/**
 * How would you design a stack which, in addition to push and pop, 
 * has function min which returns the minimum element? push, pop, min
 * should all operate in O(1) time.
 * @author asus
 *
 */
public class StackMin {

	private Stack <Integer> stack = new Stack<Integer>();
	private Stack <Integer> minBuffer = new Stack<Integer>();
	
	public void push (Integer x) {
		stack.push(x);
		
		if (minBuffer.size() == 0) {
			minBuffer.push(x);
		} else {
			if (minBuffer.peek() < x) {
				minBuffer.push(minBuffer.peek());
			} else {
				minBuffer.push(x);
			}
		}
	}
	
	public Integer pop() {
		if (stack.size() == 0) {
			return null; 
		}
		minBuffer.pop();
		return stack.pop();
	}
	
	public Integer min() {
		if (stack.size() == 0) {
			return null;
		}
		return minBuffer.peek();
	}
	
}
