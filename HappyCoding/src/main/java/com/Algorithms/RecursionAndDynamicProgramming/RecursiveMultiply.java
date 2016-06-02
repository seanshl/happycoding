package com.Algorithms.RecursionAndDynamicProgramming;

public class RecursiveMultiply {
    
    public int multiply(int m, int n) {
        int smaller = m < n? m : n;
        int bigger = smaller == m? n : m;
        return recur(smaller, bigger);
    }
    
    private int recur(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        }
        
        int half = smaller >> 1;
        int halfProd = recur(half, bigger);
        
        if (smaller % 2 == 0) {
            return halfProd + halfProd;
        } else {
            return halfProd + halfProd + bigger;
        }
    }
}
