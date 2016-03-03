package com.Algorithms.SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;

public class GroupAnagrams {
    @SuppressWarnings("hiding")
    private class AnagramComparator implements Comparator<String> {

        public int compare(String s1, String s2) {
            char []ch1 = s1.toCharArray();
            char []ch2 = s2.toCharArray();
            
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            
            return new String(ch1).compareTo(new String(ch2));
        }      
    }
    
    private AnagramComparator comparator = new AnagramComparator ();
    
    public void sortAnagram(String[] str) {       
        Arrays.sort(str, comparator);         
    }
    
    public static void main(String []args) {
        String[] str = new String[] {"ab", "cde", "uy", "ba", "dec", "ooo", "yu", "ecc"};
        GroupAnagrams test = new GroupAnagrams();
        test.sortAnagram(str);
        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            builder.append(str[i]);
            builder.append(" ");
        }
        System.out.println(builder.toString());
    }
}
