package com.Algorithms.ArraysAndStrings;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters. For eg.
 * aabcccccaaa will be a2b1c5a3. 
 * Assume, only have upper case and lowercase letters (a-z)
 * @author liushiyao
 *
 */
public class StringCompression {
    public static String compress(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        StringBuilder builder = new StringBuilder();
        char[] str = s.toCharArray();
        int count = 1;
        char currentChar = s.charAt(0);
        for(int i = 1; i < str.length; i++) {
            if (str[i] == currentChar) {
                count++;
            } else {
                builder.append(currentChar);
                builder.append(count);
                currentChar = str[i];
                count = 1;
            }
        }
        
        if (count == 1) {
            builder.append(str[str.length - 1]);
        } else {
            builder.append(currentChar);
        }
        builder.append(count);
        
        String res = builder.toString();
        
        return res.length() < s.length()? res : s;
    }
    
    public static void main(String []args) {
        String str1 = "aabcccccaaa";
        String str2 = "abcdefg";
        System.out.println(StringCompression.compress(str1));
        System.out.println(StringCompression.compress(str2));

    }
}
