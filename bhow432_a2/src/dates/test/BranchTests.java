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
	
	/**
	 * A note on branch coverage:
	 * On line 92; The for loop - if reached - has to match a month from 1 to 12,
	 * due to previous checks and validations of the month value.
	 * This means that the branch in which the for loop is not broken does not exist.
	 * Hence, #dates.Dates cannot have full statement coverage. 
	 */
	
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
	 * and is 2nd Month with valid days 
	 * and day position is not greater than 0.
	 */
	@Test
	public void testYearMultipleOf4and2MonthValid() {
			Day day = dates.Dates.dayOfWeek(2004, 2, 20);
			assertEquals(Day.Friday, day);
	}
	
	/**
	 * Year is a multiple of 4 (is a leap year)
	 * and is 8nd Month with valid days
	 * and day position is greater than 0.
	 */
	@Test
	public void testYearMultipleOf4and8Month() {
			Day day = dates.Dates.dayOfWeek(2004, 8, 20);
			assertEquals(Day.Friday, day);
	}
	
	/**
	 * Year is a not a leap year and is 7th Month,
	 * with valid number of days.
	 */
	@Test
	public void testNormalYearWithValidDays() {
			Day day = dates.Dates.dayOfWeek(2011, 12, 12);
			assertEquals(Day.Monday, day);
	}
	
	/**
	 * Year is a not a leap year and is 5th Month,
	 * with invalid number of days.
	 */
	@Test
	public void testNormalYearAndInvalidNumberOfDays() {
		try {
			dates.Dates.dayOfWeek(2003, 5, 32);
			fail("Should have failed");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date: year=" + 2003 + ", month=" + 5 + ", day=" + 32, e.getMessage());
		}
	}
	
	/**
	 * Year is a not a leap year and
	 * month which is greater than 12 (invalid).
	 */
	@Test
	public void testNormalYearAndInvalidMonthGt() {
		try {
			dates.Dates.dayOfWeek(2003, 13, 5);
			fail("Should have failed");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date: year=" + 2003 + ", month=" + 13 + ", day=" + 5, e.getMessage());
		}
	}
	
	/**
	 * Year is a not a leap year and
	 * month which is less than 1 (invalid).
	 */
	@Test
	public void testNormalYearAndInvalidMonthLeq() {
		try {
			dates.Dates.dayOfWeek(2003, 0, 5);
			fail("Should have failed");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date: year=" + 2003 + ", month=" + 0 + ", day=" + 5, e.getMessage());
		}
	}
	
	/**
	 * Year is a not a leap year and
	 * month which is valid and
	 * day which is less than 1 (invalid).
	 */
	@Test
	public void testNormalYearAndInvalidDayLeq() {
		try {
			dates.Dates.dayOfWeek(2003, 2, -1);
			fail("Should have failed");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date: year=" + 2003 + ", month=" + 2 + ", day=" + -1, e.getMessage());
		}
	}
	

}
