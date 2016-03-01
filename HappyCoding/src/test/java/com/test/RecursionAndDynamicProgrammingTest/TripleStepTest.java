package com.test.RecursionAndDynamicProgrammingTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Algorithms.RecursionAndDynamicProgramming.TripleStep;

public class TripleStepTest {
    TripleStep test = new TripleStep();

    @Test
    public void test() {
        assertEquals(test.ways(0), 0);
        assertEquals(test.ways(1), 1);
        assertEquals(test.ways(2), 2);
        assertEquals(test.ways(3), 3);
        assertEquals(test.ways(4), 5);
    }

}
