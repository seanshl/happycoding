package com.test.StacksAndQueuesTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.Algorithms.StacksAndQueues.StackMin;
import com.Algorithms.StacksAndQueues.StackMin2;

public class StackMinTest {
	
	private StackMin test = new StackMin();
	private StackMin2 test2 = new StackMin2();
	
	@Test
	public void testEmpty() {
		assertNull(test.pop());
		assertNull(test.min());
	}
	
	@Test
	public void testPushPop() {
		test.push(4);
		assertEquals(test.pop(), new Integer(4));
	}
	
	@Test
	public void testMin() {
		test = new StackMin();
		test.push(4);
		assertEquals(test.min(), new Integer(4));
		test.push(5);	
		assertEquals(test.min(), new Integer(4));
		test.push(7);
		assertEquals(test.min(), new Integer(4));
		test.push(2);
		assertEquals(test.min(), new Integer(2));
		test.pop();
		assertEquals(test.min(), new Integer(4));
		test.pop();
		assertEquals(test.min(), new Integer(4));
	}
	
	@Test
	public void test2Empty() {
		assertNull(test2.pop());
		assertNull(test2.min());
	}
	
	@Test
	public void test2PushPop() {
		test2.push(4);
		assertEquals(test2.pop(), new Integer(4));
	}
	
	@Test
	public void tes2tMin() {
		test2 = new StackMin2();
		test2.push(4);
		assertEquals(test2.min(), new Integer(4));
		test2.push(5);	
		assertEquals(test2.min(), new Integer(4));
		test2.push(7);
		assertEquals(test2.min(), new Integer(4));
		test2.push(2);
		assertEquals(test2.min(), new Integer(2));
		test2.pop();
		assertEquals(test2.min(), new Integer(4));
		test2.pop();
		assertEquals(test2.min(), new Integer(4));
	}
}
