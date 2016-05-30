package com.Algorithms.RecursionAndDynamicProgramming;

/**
 * A magic index in an array A[0..n-1] is defined to be an index such 
 * that A[i] = i. Give a sorted array of distinct integers, write a 
 * method to find a magic index, if exists, in arrayA
 * 
 * @Folllow UP
 * what if the vvalues are not distinct?
 * @author liushiyao
 *
 */
public class MagicIndex {
    public static int findIndex(int[] array) {
        return binary(array, 0, array.length - 1);
    }
    
    public static int binary(int[]a, int left, int right) {
        if (left > right) return -1;
        
        int mid = (left + right) >> 1;
        if (a[mid] == mid) {
            return mid;
        } else  if (a[mid] > mid) {
            return binary(a, left, mid - 1);
        } else {
            return binary(a, mid + 1, right);
        }
    }
    
    public static int followUp(int[] array) {
        return binaryFollow(array, 0, array.length - 1);
    }
    
    public static int binaryFollow(int[] array, int left, int right) {
        if (left > right) return -1;
        
        int mid = (left + right) >> 1;
        int midValue = array[mid];
        if (midValue == mid) {
            return mid;
        }
        
        int leftIndex = Math.min(mid - 1, midValue);
        int leftRes = binaryFollow(array, left, leftIndex);
        if (leftRes >= 0) {
            return leftRes;
        }
        
        int rightIndex = Math. max(mid + 1, midValue);
        int rightRes = binaryFollow(array, rightIndex, right);
        
        return rightRes;
    }
}
