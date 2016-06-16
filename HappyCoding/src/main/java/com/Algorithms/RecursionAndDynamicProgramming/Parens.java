package com.Algorithms.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement an algo to print all valid combinations of n pairs of parentheses
 * @author liushiyao
 *
 */
public class Parens {
    public static List<String> parens(int n) {
        List<String> res = new ArrayList<>();
        
        if (n <= 0) return res;
        
        recur(res, n, n, new char[2 * n ], n);
        
        return res;
        
    }
    
    private static void recur(List<String> res, int leftRem, int rightRem, char[] current, int count) {
        if (leftRem < 0 || leftRem > rightRem) {
            return;
        }
        
        if (leftRem == 0 && rightRem == 0) {
            String s = String.copyValueOf(current);
            res.add(s);
        } else {
            if (leftRem > 0) {
                current[count] = '(';
                recur(res, leftRem - 1, rightRem, current, count + 1);
            } 
            
            if (rightRem > leftRem) {
                current[count] = ')';
                recur(res, leftRem, rightRem - 1, current ,count + 1);
            }
        }
    }
}
