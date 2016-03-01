package com.Algorithms.StacksAndQueues;

import java.util.Stack;

import com.Exceptions.InvalidInputException;

/**
 * Imaging a (literal) stack of plates. If the stack gets too high, it might topple. 
 * Therefore, in real life, we should likely start a new stack when the previous stack exceeds some 
 * threshold, Implement a data structure SetOfStacks that mimics this. SetOfStacks should be 
 * composed of several stacks and should create a new stack once the previous one exceeds capacity
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop()s should return
 * the save values as it would if there were just a single stack).
 * 
 * @author liushiyao
 *
 */
public class StackOfPlates extends Stack {

    private Stack<Stack<Integer>> stacks;
    private int threshold;
    
    public StackOfPlates(int threshold) throws InvalidInputException {
        if (threshold <= 0) {
            throw new InvalidInputException();
        }
        this.threshold = threshold;
        stacks = new Stack<Stack<Integer>>();
    }
    
    
    
    public void push(Integer x) {
        if (x == null) return;
        if (stacks.isEmpty() || stacks.peek().size() >= threshold) {
            Stack<Integer> stack = new Stack<Integer> ();
            stack.push(x);
            stacks.push(stack);
        } else {
           stacks.peek().push(x);
        }
    }
    
    public Integer pop() {
        if (stacks.isEmpty()) {
            return null;
        } 
        
        if (stacks.peek().isEmpty()) {
            stacks.pop();
            return pop();
        }
        return stacks.peek().pop();
    }
    
    public Integer peek() {
        if (stacks.isEmpty()) {
            return null;
        }
        if (stacks.peek().isEmpty()) {
            stacks.pop();
            return peek();
        }
        return stacks.peek().peek();
    }
    
    public int size() {
        return stacks.size();
    }
    
    public boolean isEmpty() {
        return stacks.isEmpty();
    }
    
    
}
