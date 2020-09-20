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
	
	/*
	 * A note on the test class;
	 * Due to the complicated nature of the input space, 
	 * I decided on making the boundaries of dates into equivalence classes.
	 * 
	 * I have chosen the equivalence class of the 29th of February on a leap year,
	 * as it is a distinct day/date that is only valid on a leap year 
	 * and non-valid otherwise. This is the class selected as it is one
	 * of the more tricky aspects of calendar keeping. It is also something that
	 * requires logic specifically for its use. It is also a unique equivalence class,
	 * as all leap years are expected to behave with 29th of February a valid date, 
	 * and all non-leap years are expected to treat 29th Feb as a non-valid date.
	 * 
	 * This equivalence class was chosen as the class has not been covered explicitly
	 * in the branch tests or the du-path test. The class isn't required to be covered 
	 * in order to receive full branch coverage for BranchTest and in the DataFlowTest,
	 * a du-path was selected that does not have an input of the 29th of Feb in a leap year.
	 */
	@Rule
	public Timeout globalTimeout = Timeout.millis(100);
	/**
	 * Test a leap year and the 29th of February.
	 * As is a leap year, 29th Feb should be valid.
	 */
	@Test
	public void testLeapYearDay() {
		Day day = dates.Dates.dayOfWeek(2020,2,29);
		assertEquals(Day.Saturday, day);
	}

}