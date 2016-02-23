package com.Algorithms.BitManipulation;

import org.springframework.beans.factory.annotation.Autowired;

import com.Exceptions.InvalidInputException;
import com.Utils.StringUtil;

/**
 * You are given two 32-bit numbers, N and M, and two bit positions i and j.
 * Write a method to insert M into N such that M starts at bit j and ends at bit i. 
 * You can assume  that the bits j through i have enough space to fit all of M. That is,
 * if M = 10011, you can assume that these are at least 5 bits between j and i. You would not, for example ,
 * have j = 3 and i =2, because M could not fully fit between bit 3 and bit 2.
 * 
 * Example
 * Input N = 10000000000, M=10011, i = 2, j = 6
 * Output N =10001001100
 * @author liushiyao
 *
 */
public class Insertion {
    
    public String insert(String mString, String nString, int i, int j) throws InvalidInputException {
        if (j <= i || i < 0 || j >= nString.length() || nString.length() < mString.length()) {
            throw new InvalidInputException("Your input is invalid");
        }
        
        int allOnes = ~0;
        int left = allOnes << (j + 1);
        int right = (1 << i) - 1;
        
        int M = StringUtil.toDecimalInteger(mString);
        int N = StringUtil.toDecimalInteger(nString);
        
        int mask = left | right;
        
        return Integer.toBinaryString(N & mask | M << i);    
    }
   
}
