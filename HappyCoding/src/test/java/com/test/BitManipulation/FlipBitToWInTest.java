package com.test.BitManipulation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Algorithms.BitManipulation.FlipBitToWin;

public class FlipBitToWInTest {
    private FlipBitToWin test = new FlipBitToWin();
    @Test
    public void test() {
        assertEquals(test.longestSequence(1775), 8);
    }

}
