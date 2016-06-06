package com.Algorithms.RecursionAndDynamicProgramming;

import java.util.ArrayList;

/**
 * Write a method to compute all permutations if a string of unique characters
 * @author liushiyao
 *
 */
public class PermutationWithoutDups {
    
    public ArrayList<String> calc(String s) {
        if (s == null) return null;
        
        ArrayList<String> perm = new ArrayList<>();
        
        if (s.length() == 0) {
            perm.add("");
            return perm;
        }
        
        char  first = s.charAt(0);
        String remainder = s.substring(1);
        
        ArrayList<String> words = calc(remainder);
        for (String word: words) {
            for (int j = 0; j <= word.length(); j++) {
                String str = insert(word, first, j);
                perm.add(str);
            }
        }
        
        return perm;
    }
    
    private String insert(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        
        return start + c + end;
    }
    
    public static void main(String []args) {
        PermutationWithoutDups test = new PermutationWithoutDups();
        
        String str ="abc";
        ArrayList<String> res = test.calc(str);
        
        System.out.println(res.toString());
    }
}
