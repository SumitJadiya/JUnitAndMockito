package com.in28minutes.junit.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit Test File 
 * 
 * @author sumitjadiya
 *
 */
public class StringHelperTest {
	StringHelper helper;
	
	@Before
	public void before() {
		helper = new StringHelper();
	}

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

	@Test
	public void testAreFirstAndLastCharacterTheSame_BasicNegativeScenario() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
	
	@Test
	public void testAreFirstAndLastCharacterTheSame_BasicPositiveScenario() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}	
	
	@After
	public void after() {
		helper = null;
	}
}