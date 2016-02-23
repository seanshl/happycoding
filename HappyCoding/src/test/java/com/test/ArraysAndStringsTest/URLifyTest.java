package com.test.ArraysAndStringsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.Algorithms.ArraysAndStrings.URLify;

public class URLifyTest {
    URLify test;
    
    @Before
    public void onInit() {
       test = new URLify();
    }
    @Test
    public void test() {
        assertEquals(test.URLify("Mr John Smith           ", 13), "Mr%20John%20Smith");
    }

}
