package edu.sc.cse4495.MeetingPlanner;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class MeetingTest {
	// Add test methods here.
    // You are not required to write tests for all classes.

    @Test
    public void meeting_month(){
        Meeting fixed = new Meeting(5, 10);
        assertEquals(5, fixed.getMonth());

    }

    @Test
    public void meeting_day(){
        Meeting fixed = new Meeting(10, 20);
        assertEquals(20, fixed.getDay());

    }

    @Test
    public void meeting_day1(){
        Meeting fixed = new Meeting(10, 32);
        assertNotEquals(25, fixed.getDay());

    }

    @Test
    public void meeting_description(){
        Meeting fixed = new Meeting(10, 32, "Important Meeting");
        assertTrue(fixed.getDescription()=="Important Meeting");

    }

    @Test
    public void meeting_startTime(){
        Meeting fixed = new Meeting(10, 32, 10, 12);
        assertTrue(fixed.getStartTime()==10);

    }

    @Test
    public void meeting_endTime(){
        Meeting fixed = new Meeting(10, 32, 10, 12);
        assertTrue(fixed.getEndTime()==12);

    }

    @Test
    public void meeting_room(){
        ArrayList<Person>name= new ArrayList<>();
        name.add(new Person("Rafi"));
        Room room= new Room("210");
        Meeting fixed = new Meeting(10, 32, 10, 20, name, room, "emnei meeting");
        assertEquals("210", fixed.getRoom().getID());

    }
}
