package com.Algorithms.SortingAndSearching;

/**
 * Given a sorted array of n integers that has been rotated an unknow number of 
 * times, write code to find an element in the array. You may assuse that the array
 * has originally sorted in increasing order.
 * @author liushiyao
 *
 */
public class SearchInRotatedArray {
    public  int search(int[] array, int e) {
        return search(array, e, 0, array.length - 1);
    }
    
    private int search(int[] a, int e, int start, int end) {
        int mid = (start + end) / 2;
        if (a[e] == a[mid]) {
            return mid;
        }
        if (end < start) {
            return -1;
        }
        
        if(a[start] < a[end]) {
            if (e >= a[start] && e <= a[mid]) {
                return search(a, start, mid - 1, e);
            } else {
                return search(a, mid + 1, end, e);
            }
        } else if (a[mid] < a[start]) {
            if (e > a[mid] && e <= a[end]) {
                return search(a, mid + 1, end, e);
            } else {
                return search(a, start, mid - 1, e);
            }
        } else if (a[start] == a[mid]) {
            if ( a[mid] != a[end]) {
                return search (a, mid + 1, end, e);
            } else {
                int res = search(a, start, mid - 1, e);
                if (res == -1) {
                    return search(a, mid + 1, end, e);
                } else {
                    return res;
                }
            }
        }
        return -1;
    }
}
