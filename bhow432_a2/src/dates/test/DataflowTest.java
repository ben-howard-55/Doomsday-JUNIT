package dates.test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import dates.Dates.Day;

/**
 * SOFTENG 254 Assignment 2 DataflowTest
 *
 * Author: Benjamin James Howard, bhow432
 **/
public class DataflowTest {
	/**
	 * This du-path has not been tested by other tests as none
	 * of the branch tests test the case when position is equal to 0.
	 * 
	 * This only happens when both the anchor day is Sunday and 
	 * the day is a doomsday or when the ordinality of the anchor day 
	 * and the days until doomsday are equal in magnitude 
	 * and days until doomsday is negative (before doomsday date).
	 * 
	 * Hence, it is a rare circumstance that will not happen often,
	 * but still can happen. Hence, the du-path adds to the quality
	 * as it tests something new and something that could of been
	 * not otherwise tested or thought about by the developer 
	 * and wouldn't have been by branch coverage or 
	 * EQUIVALENCE CLASS TEST.
	 */

	@Rule
	public Timeout globalTimeout = Timeout.millis(100);
	
	/**
	 * Testing the du-path of int position,
	 * defined on line 102 and used on line 111.
	 * du-path of; 102,103,105,107,111 (excluding { and }).
	 * 

	 */
	@Test
	public void testPositionDuPath() {
		Day day = dates.Dates.dayOfWeek(2100,10,10);
		assertEquals(Day.Sunday, day);
	}
	
	

}
