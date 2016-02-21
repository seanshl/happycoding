package com.Algorithms.ArraysAndStrings;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutaion of the other.
 * @author shiyao
 *
 */
public class CheckPermutation {
	/**
	 * sort str1 and str2, then compare.
	 * @param str1
	 * @param str2
	 * @return
	 */
	public boolean checkWithOrdering(String str1, String str2) {
		try {
			if (str1.length() != str2.length()) {
				return false;
			} 
			
			char []buffer1 = str1.toCharArray();
			char []buffer2 = str2.toCharArray();
						
			Arrays.sort(buffer1);
			Arrays.sort(buffer2);
			
			return new String(buffer1).equals(new String(buffer2));
			
		} catch (NullPointerException e) {
			
		}
		return false;
	}
	
	/**
	 * Assume Ascii 256.
	 * @param str1
	 * @param str2
	 * @return
	 */
	public boolean checkWithBigBuffer(String str1, String str2) {
		try {
			if (str1.length() != str2.length()) {
				return false;
			}
			
			int []buffer = new int[256];
			for (int i = 0; i < str1.length(); i++) {
				buffer[str1.charAt(i)] ++;
			}
			for (int i = 0; i < str2.length(); i++) {
				if (buffer[str2.charAt(i)] <= 0) {
					return false;
				}
				buffer[str2.charAt(i)] --;
			}
			return true;
		} catch (NullPointerException e) {
			
		}
		return false;
	}
	
}
