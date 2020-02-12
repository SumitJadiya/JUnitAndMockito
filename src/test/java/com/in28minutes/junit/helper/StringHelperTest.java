package com.in28minutes.junit.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringHelperTest {
	StringHelper helper = new StringHelper();

	@Test
	public void testTruncateAInFirst2Positions_AinFirstTwoPosition() {

		String actualValue = helper.truncateAInFirst2Positions("AACD");
		assertEquals("CD", actualValue);
	}

	@Test
	public void testTruncateAInFirst2Positions_AinFirstPosition() {
		String actualValue = helper.truncateAInFirst2Positions("ACD");
		assertEquals("CD", actualValue);
	}

	@Test
	public void testTruncateAInFirst2Positions_AinLastPosition() {

		String actualValue = helper.truncateAInFirst2Positions("CDAA");
		assertEquals("CDAA", actualValue);
	}

}