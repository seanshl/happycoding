package com.Algorithms.ArraysAndStrings;

/**
 * Given an image represented by an N N matrix, where each pixel
 * in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you 
 * do this in place.
 * @author liushiyao
 *
 */
public class RotateMatrix {
    
    public static void rotate(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            return;
        }
        int n = matrix.length;
        
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            
            for (int j = first; j < last; j++) {
                int offset = j - first;
                
                int temp = matrix[first][j];
                
                matrix[first][j] = matrix[last - offset][first];
                
                matrix[last - offset][first] = matrix[last][last - offset];
                
                matrix[last][last - offset] = matrix[j][last];
                
                matrix[j][last] = temp;
            }
        }
    }
}
