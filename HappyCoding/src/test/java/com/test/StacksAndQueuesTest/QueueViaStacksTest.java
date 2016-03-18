package com.test.StacksAndQueuesTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Algorithms.StacksAndQueues.QueueViaStacks;

public class QueueViaStacksTest {
    private QueueViaStacks test = new QueueViaStacks();
    @Test
    public void test() {
        assertNull(test.dequeue());
        test.enqueue(1);
        assertTrue(test.peek() == 1);
        assertTrue(test.dequeue() == 1);
        
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        
        assertTrue(test.dequeue() == 1);
        test.enqueue(4);
        
        assertTrue(test.dequeue() == 2);
        assertTrue(test.dequeue() == 3);
        assertTrue(test.dequeue() == 4);
        assertNull(test.dequeue());
    }

}
