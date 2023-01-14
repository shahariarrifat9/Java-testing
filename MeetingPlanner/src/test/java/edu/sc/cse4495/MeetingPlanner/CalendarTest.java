package edu.sc.cse4495.MeetingPlanner;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalendarTest {
	// Add test methods here.
	// You are not required to write tests for all classes.

	@Test
	public void testAddMeeting_holiday() {
		// Create Midsommar holiday
		Meeting christmas = new Meeting(6, 26, "Midsommar");
		Calendar calendar = new Calendar();
		// Add to calendar object.
		try {
			calendar.addMeeting(christmas);
			// Verify that it was added.
			Boolean added = calendar.isBusy(6, 26, 0, 23);
			assertTrue("Midsummer should be marked as busy on the calendar",added);
		} catch(TimeConflictException e) {
			fail("Should not throw exception: " + e.getMessage());
		}
	}




	@Test
	public void negValue() {
		Meeting meeting = new Meeting(-4, -30, "Negative Month and day.");
		Calendar calendar = new Calendar();

		Throwable e = assertThrows(TimeConflictException.class,
				()->{calendar.addMeeting(meeting);});
		assertEquals("Day does not exist.", e.getMessage());
	}

	@Test
	public void negativeStartTime() {
		Meeting meeting = new Meeting(5,24,-1,9);
		Calendar calendar = new Calendar();

		Throwable e = assertThrows(TimeConflictException.class,
				()->{calendar.addMeeting(meeting);});
		assertEquals("Illegal hour.", e.getMessage());
	}
	@Test
	public void negativeEndTime() {
		Meeting meeting = new Meeting(5,24,1,-9);
		Calendar calendar = new Calendar();

		Throwable e = assertThrows(TimeConflictException.class,
				()->{calendar.addMeeting(meeting);});
		assertEquals("Illegal hour.", e.getMessage());
	}


	@Test
	public void invalidTime() {
		Meeting meeting = new Meeting(5,24,8,5);
		Calendar calendar = new Calendar();

		Throwable e = assertThrows(TimeConflictException.class,
				()->{calendar.addMeeting(meeting);});
		assertEquals("Meeting starts before it ends.", e.getMessage());
	}


}
