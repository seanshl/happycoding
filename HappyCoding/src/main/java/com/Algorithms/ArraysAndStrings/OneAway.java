package com.Algorithms.ArraysAndStrings;

public class OneAway {
    public static boolean isOneAway(String a, String b) {
        if (a.length() == b.length()) {
            return isOneEdit(a, b);
        } else if (a.length() == b.length() + 1) {
            return isOneInsert(a, b);
        } else if (a.length() == b.length() - 1) {
            return isOneInsert(b, a);
        } else {
            return false;
        }
        
    }
    
    public static boolean isOneInsert(String a, String b) {
        boolean diffFound = false;
        for (int i = 0, j = 0; i < a.length(); i++, j++) {
            if (a.charAt(i) != b.charAt(j)) {
                if (diffFound) {
                    return false;
                } else {
                    i++;
                    diffFound = true;
                }
            }
        }
        
        return true;
    }
    
    public static boolean isOneEdit(String a, String b) {
        boolean diffFound = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (diffFound) {
                    return false;
                } else {
                    diffFound = true;
                }
            }
        }
        
        return true;
    }
}
