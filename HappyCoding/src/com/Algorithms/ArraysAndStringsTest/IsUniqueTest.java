package com.Algorithms.ArraysAndStringsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.Algorithms.ArraysAndStrings.IsUnique;

public class IsUniqueTest {
	
	private static IsUnique isUnique = new IsUnique();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAllUniqueEmptyString() {
		String str = "";
		boolean res = isUnique.allUniqueWithSet(str);
		assertFalse(res);
	}
	
	@Test
	public void testAllUniqueNullString() {
		String str = null;
		boolean res = isUnique.allUniqueWithSet(str);
		assertFalse(res);
	}
	
	@Test
	public void testAllUnitFalse() {
		String str = "abcddefghijklmn";
		boolean res = isUnique.allUniqueWithSet(str);
		assertFalse(res);
	}
	
	@Test
	public void testAllUnitTrue() {
		String str = "abcdefghijklmn";
		boolean res = isUnique.allUniqueWithSet(str);
		assertTrue(res);
	}
	
	@Test
	public void testAllUniqueWithArrayEmptyString() {
		String str = "";
		boolean res = isUnique.allUniqueWithArray(str);
		assertFalse(res);
	}
	
	@Test
	public void testAllUniqueWithArrayNullString() {
		String str = null;
		boolean res = isUnique.allUniqueWithArray(str);
		assertFalse(res);
	}
	
	@Test
	public void testAllUnitWithArrayFalse() {
		String str = "abcddefghijklmn";
		boolean res = isUnique.allUniqueWithArray(str);
		assertFalse(res);
	}
	
	@Test
	public void testAllUnitWithArrayTrue() {
		String str = "abcdefghijklmn";
		boolean res = isUnique.allUniqueWithArray(str);
		assertTrue(res);
	}
	
	@Test
	public void testAllUnitWithBitFalse() {
		String str = "abcddefghijklmn";
		boolean res = isUnique.allUniqueWithBit(str);
		assertFalse(res);
	}
	
	@Test
	public void testAllUnitWithBitTrue() {
		String str = "abcdefghijklmn";
		boolean res = isUnique.allUniqueWithBit(str);
		assertTrue(res);
	}

}
