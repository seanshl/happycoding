package com.test.StacksAndQueuesTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.Algorithms.StacksAndQueues.StackOfPlates;
import com.Exceptions.InvalidInputException;

public class StackOfPlatesTest {
    private StackOfPlates test;
    
    @Before
    public void onInit() throws InvalidInputException {
         test = new StackOfPlates(3);
    }
    
    @Test
    public void test1() {
        assertNull(test.pop());
        assertNull(test.peek());
        test.push(1);
        assertEquals(test.size(), 1);
        assertEquals(test.peek(), new Integer(1));
    }
    
    @Test
    public void test2() {
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        assertEquals(test.size(), 2);
        assertEquals(test.peek(), new Integer(4));
        assertEquals(test.pop(), new Integer(4));
        assertEquals(test.pop(), new Integer(3));
        assertEquals(test.pop(), new Integer(2));
        assertEquals(test.pop(), new Integer(1));
        assertNull(test.pop());
    }

}
