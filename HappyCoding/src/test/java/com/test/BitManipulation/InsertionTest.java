package com.test.BitManipulation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.Algorithms.BitManipulation.Insertion;
import com.Exceptions.InvalidInputException;

public class InsertionTest {
    private Insertion test;
    
    @Before
    public void onInit() {
        test = new Insertion();
    }
    @Test
    public void test() {
        try {
            assertEquals(test.insert("10011", "10000000000", 2, 6), "10001001100");
        } catch (InvalidInputException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
