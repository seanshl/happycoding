package com.Algorithms.ArraysAndStrings;

/**
 * Write an algo such that if an element in an MXN matrix is 0, 
 * its entire row and column are set to 0;
 * @author liushiyao
 *
 */
public class ZeroMatrix {
    
    public static void zeroMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        boolean rowHasZero = false;
        boolean colHasZero = false;
        
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }
        
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }
        
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                nullifyCol(matrix, j);
            }
        }
        
        if (rowHasZero) {
            nullifyRow(matrix, 0);
        }
        
        if (colHasZero) {
            nullifyCol(matrix, 0);
        }
    }
    
    private static void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }
    
    private static void nullifyCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

}
