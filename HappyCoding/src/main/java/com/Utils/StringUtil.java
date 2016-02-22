package com.Utils;

import com.Exceptions.InvalidInputException;

public class StringUtil {
    public StringUtil() {}
    
    /**
     * transfer a string consists of 1 or 0 to integer.
     * @param s
     * @return
     * @throws InvalidInputException
     */
    public int toDecimalInteger(String s) throws InvalidInputException{
        if (s.isEmpty()) {
            throw new InvalidInputException("your input is invalid");
        }
        char[] str = s.toCharArray();
        int res = 0;
        int count = 0;
        
        for (int i = str.length - 1; i >= 0; i--) {    
            int bit = (int) str[i] - 48;
            if (!(bit == 0 || bit ==1)) throw new InvalidInputException("your input is invalid");
            
            res += bit * Math.pow(2, count++);
        }
        return res;
    }
    
    /**
     * check if the string is null or consists of all whitespace.
     * @param s
     * @return
     */
    public boolean isBlank(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                return false;
            }
        }     
        return true;
    }

}
