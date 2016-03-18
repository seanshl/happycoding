package com.Algorithms.StacksAndQueues;

import java.util.Stack;
public class QueueViaStacks {

    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;
    
    public QueueViaStacks() {
        stack1 = new Stack<Integer> ();
        stack2 = new Stack<Integer> ();
    }
    
    public void enqueue(int x) {
        stack1.push(x);
    }
    
    public Integer dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return null;
            }
            transfer();
            return dequeue();
        } else {
            return stack2.pop();
        }
    }
    
    public Integer peek() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return null;
            }
            transfer();
            return peek();
        } else {
            return stack2.peek();
        }
    }
    
    private void transfer() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
