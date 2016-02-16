package com.test.ArraysAndStringsTest;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

import com.Algorithms.ArraysAndStrings.CheckPermutation;

public class CheckPermutaionTest {

	private String str1 = "";
	private String str2 = "abcdefghijklmnopqrstuvwxyz1234567";
	private String str3 = "1234567qwertyuiopasdfghjklzxcvbnm";
	private String str4 = "3a21312sfsdasd3534z";
	private String str5 = "abccedfghijklmnpoqw12xvnwodzleroa";
	private String str6 = null;

	private CheckPermutation test = new CheckPermutation();

	@Test
	public void testWithOrdering() {
		Long t1 = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			assertFalse(test.checkWithOrdering(str1, str2));
			assertFalse(test.checkWithOrdering(str2, str4));
			assertFalse(test.checkWithOrdering(str2, str5));

			assertFalse(test.checkWithOrdering(str3, str6));

			assertTrue(test.checkWithOrdering(str2, str3));
		}
		Long t2 = System.currentTimeMillis();
		Logger logger = Logger.getLogger("Timing");
		logger.info("testWithOrdering uses: " + (t2 - t1));
	}

	@Test
	public void testWithBuffer() {
		Long t1 = System.currentTimeMillis();

		for (int i = 0; i < 1000; i++) {
			assertFalse(test.checkWithBigBuffer(str1, str2));
			assertFalse(test.checkWithBigBuffer(str2, str4));
			assertFalse(test.checkWithBigBuffer(str2, str5));

			assertFalse(test.checkWithBigBuffer(str3, str6));

			assertTrue(test.checkWithBigBuffer(str2, str3));
		}
		Long t2 = System.currentTimeMillis();
		Logger logger = Logger.getLogger("Timing");
		logger.info("testWithBuffer uses: " + (t2 - t1));
	}

}
