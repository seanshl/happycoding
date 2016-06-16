package com.Algorithms.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Write a method to compute all permutations of a string of unique characters.
 * @author liushiyao
 *
 */
public class PermutationWithDups {
    public List<String> permute(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        
        HashMap<Character, Integer> map = this.buildFreqTable(s);
        
        this.recur(res, map, s, 0, "");
        return res;
    }
    
    private HashMap<Character, Integer> buildFreqTable(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        
        return map;
    }
    
    private void recur(List<String> result, HashMap<Character, Integer> map, String s, int index, String prefix) {
        if (index == s.length()) {
            result.add(prefix);
            return;
        }
        
        for (char c : s.toCharArray()) {
            int count = map.get(c);
            if (count <= 0) continue;
            
            map.put(c, count - 1);
            recur(result, map, s, index + 1, prefix + c);
            map.put(c, count);
        }
    }

}
