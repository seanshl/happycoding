package com.Algorithms.ArraysAndStrings;
/**
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space
 * at the end to hold the additional characters, and that you are given the 'true' length of the string.
 * Using char array.
 * Example "Mr John Smith       ", 13
 * output "Mr%20John%20Smith"
 * @author liushiyao
 *
 */
public class URLify {
    public String URLify(String string, int length) {
        char []str = string.toCharArray();
        char []res = new char[string.length()];
        
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                res[count++] = '%';
                res[count++] = '2';
                res[count++] = '0';
            } else {
                res[count++] = str[i];
            }
        }
        
        return new String(res).trim();
    }
}
