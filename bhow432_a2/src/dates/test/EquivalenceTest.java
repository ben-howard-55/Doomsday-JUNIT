package dates.test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import dates.Dates.Day;

/**
 * SOFTENG 254 Assignment 2 EquivalenceTest
 *
 * Author: Benjamin James Howard, bhow432
 **/

public class EquivalenceTest {

	@Rule
	public Timeout globalTimeout = Timeout.millis(100);
	
	/*
	 * 
	 */
	@Test
	public void testBoundary1753() {
		Day day = dates.Dates.dayOfWeek(1753,1,1);
		assertEquals(Day.Monday, day);
	}

}