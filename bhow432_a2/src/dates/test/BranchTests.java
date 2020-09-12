package dates.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import dates.Dates.Day;

/**
 * SOFTENG 254 Assignment 2 BranchTests
 *
 * Author: Benjamin James Howard, bhow432
 **/

public class BranchTests {
	
	@Rule
	public Timeout globalTimeout = Timeout.millis(100);
	
	/**
	 * Year is a multiple of 400 (is a leap year)
	 * and is less than 1753 (not valid).
	 */
	@Test
	public void testYearMultipleOf400andInvalid() {
		try {
			dates.Dates.dayOfWeek(1600, 1, 1);
			fail("Should have failed");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date: year=" + 1600 + ", month=" + 1 + ", day=" + 1, e.getMessage());
		}
	}
	
	/**
	 * Year is a multiple of 100 (is a leap year)
	 * and has invalid day and month.
	 */
	@Test
	public void testYearMultipleOf100andInvalidDayAndMonth() {
		try {
			dates.Dates.dayOfWeek(1900, 0, 0);
			fail("Should have failed");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date: year=" + 1900 + ", month=" + 0 + ", day=" + 0, e.getMessage());
		}
	}
	
	/**
	 * Year is a multiple of 4 (is a leap year)
	 * and is 2nd Month, but has too many days (invalid).
	 */
	@Test
	public void testYearMultipleOf4and2MonthInvalid() {
		try {
			dates.Dates.dayOfWeek(2004, 2, 30);
			fail("Should have failed");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date: year=" + 2004 + ", month=" + 2 + ", day=" + 30, e.getMessage());
		}
	}
	
	/**
	 * Year is a multiple of 4 (is a leap year)
	 * and is 2nd Month, but has valid days.
	 */
	@Test
	public void testYearMultipleOf4and2MonthValid() {
			Day day = dates.Dates.dayOfWeek(2004, 2, 20);
			assertEquals(Day.Friday, day);
	}
	

}
