package com.Algorithms.RecursionAndDynamicProgramming;

import java.util.HashMap;

/**
 * Given an infinite number of quarters, dimes nickels, and 
 * pennies, write code to calculate the number osf ways of
 * representing n cents.
 * @author liushiyao
 *
 */
public class Coins {
    
    public int ways(int n) {
        int[] dimes = new int[]{25, 10, 5, 1};
        HashMap<Integer, Integer> cache = new HashMap<>();
        
        return recur(n, dimes, cache, 0);
    }
    
    private int recur(int n, int[] dimes, HashMap<Integer, Integer> cache, int index) {
        if (cache.containsKey(n)) return cache.get(n);
        
        if (index  >= dimes.length - 1) return 1;
        
        int denomAmount = dimes[index];
        int count = 0;
        for (int i = 0; i * denomAmount <= n; i++) {
            int remaining = n - i * denomAmount;
            count += recur(remaining, dimes, cache, index + 1);
        }
        
        cache.put(n, count);
        return count;
    }
}
