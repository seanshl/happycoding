package com.Algorithms.BitManipulation;

/**
 * You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to 
 * find the length of the longest sequence of 1s you could create.
 * @author liushiyao
 *
 */
public class FlipBitToWin {

    public int longestSequence(Integer x) {
        char []bits = Integer.toBinaryString(x).toCharArray();
        
        int length = bits.length;
        boolean metZero = false;
        int count = 0;
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            if ((x & 1)== 1) {
                count ++;
            } else {
                if (!metZero) {
                    metZero = true;
                    count ++;
                } else {
                    maxLength = Math.max(maxLength, count);
                    count = 0;
                    metZero = false;
                }
            }
            x = x >> 1;
        }
        return maxLength;
    }
}
