package com.Algorithms.ArraysAndStrings;

/**
 * Assume you have a method isSubstring whch checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a rotation
 * of s1 using only one call to isSubstring.
 * @author liushiyao
 *
 */
public class StringRotation {
    public boolean isRotation(String s1, String s2) {
        return isSubstring(s1 + s1, s2);
    }
    
    
    private boolean isSubstring(String s1, String s2) {
        return true;
    }
}
