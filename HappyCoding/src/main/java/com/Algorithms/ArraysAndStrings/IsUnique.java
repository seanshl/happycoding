package com.Algorithms.ArraysAndStrings;

import java.util.HashSet;

/**
 * Implement an algorithms to determine if a string has all unique characters.
 * followup: don't use additional data structures.
 * @author shiyao
 *
 */
public class IsUnique {
	/**
	 * Use a hash set.
	 * @param str
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean allUniqueWithSet(String str) {
		if (str != null && !str.isEmpty()) {
			HashSet set = new HashSet();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (!set.contains(c)) {
					set.add(c);
				} else {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Use array to hold the value. Assuming ASCII, 256 size.
	 * @param str
	 * @return
	 */
	public boolean allUniqueWithArray(String str) {
		if (str != null && !str.isEmpty()) {
			if (str.length() > 256) {
				return false;
			} 
			boolean [] unique_flag = new boolean[256];
			for (int i = 0; i < str.length(); i++) {
				int c = str.charAt(i);
				if (unique_flag[c]) {
					return false;
				} else {
					unique_flag[c] = true;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Use bit vector to hold the value, assuming all lower case.
	 * @param str
	 * @return
	 */
	public boolean allUniqueWithBit(String str) {
		if (str != null && !str.isEmpty()) {
			int check = 0;
			for (int i = 0; i < str.length(); i++) {
				int offset = str.charAt(i) - 'a';
				if ((check & 1 << offset) > 0) {
					return false;
				} else {
					check |= 1 << offset;
				}

			}
			return true;
		} else {
			return false;
		}
	}
}
