package com.Algorithms.ArraysAndStrings;

import java.util.HashMap;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rearrangement of letters. The palindrome does not need to be limited to just
 * ditionary words.
 * @author liushiyao
 *
 */
public class PalindromePermutation {
    private HashMap<Character, Integer> map = new HashMap<Character, Integer> ();
    
    public boolean isPalindromePermutation(String str) {
        str = str.toLowerCase();
        buildHashMap(str);
        return isPalindromePermutation();
    }
    
    private boolean isPalindromePermutation() {
        int validation = 0;
        for(Integer count: map.values()) {
            if (validation > 1) {
                return false;
            }
            if (count%2 != 0) {
                validation ++;
            }
        }
        return true;
    }
    
    private void buildHashMap(String str) {
        char [] chars = str.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                int currentCount = map.get(chars[i]);
                map.put(chars[i], ++currentCount);
            } else {
                map.put(chars[i], 1);
            }
        }
    }
}
