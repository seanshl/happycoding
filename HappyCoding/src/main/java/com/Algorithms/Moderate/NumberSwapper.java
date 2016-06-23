package com.Algorithms.Moderate;

/**
 * Write a function to swap a number in place(without temporary variable)
 * @author liushiyao
 *
 */
public class NumberSwapper {
    
    public static void swap(int[] nums, int i , int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
    
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 5, 6, 7};
        
        swap(a, 2, 4);
        
        for (int i : a) {
            System.out.println(i);
        }
    }

}
