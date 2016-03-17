package com.test.ArraysAndStringsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.Algorithms.ArraysAndStrings.PalindromePermutation;

public class PalindromePermutationTest {
    private PalindromePermutation test;
    
    @Before
    public void onInit() {
        test = new PalindromePermutation();
    }

    @Test
    public void testTrue() {
        String[] testString = {"Tact Coa", "a", "Aab", "352ab253a"};
        for (int i = 0 ; i < testString.length; i++) {
            assertTrue(test.isPalindromePermutation(testString[i]));
            onInit();
        }
    }
    
    @Test
    public void testFalse() {
        String[] testString = {"Tact3 Coa", "ab", "AabBC", "352ab254a"};
        for (int i = 0 ; i < testString.length; i++) {
            assertFalse(test.isPalindromePermutation(testString[i]));
        }
    }
}
