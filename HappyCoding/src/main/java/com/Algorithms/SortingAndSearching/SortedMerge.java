package com.Algorithms.SortingAndSearching;

/**
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the 
 * end to hold B. Write a method to merge B into A in sorted order.
 * @author liushiyao
 *
 */
public class SortedMerge {
    
    public void sort(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int indexMerged = lastB + lastA - 1;
        
        while (indexB >=0 ) {
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged--] = a[indexA--];
            } else {
                a[indexMerged--] = b[indexB--];
            }
        }
    }
}
