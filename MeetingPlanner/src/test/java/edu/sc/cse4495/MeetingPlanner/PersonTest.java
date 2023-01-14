package edu.sc.cse4495.MeetingPlanner;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertThrows;
public class PersonTest {
    //add meeting

    @Test
    public void testMonths() {
        Person person = new Person();
        Throwable e = assertThrows(TimeConflictException.class,
                ()->{person.isBusy(14,1,10,12);}
        );
        assertEquals("Month error.", e.getMessage());
    }
    @Test
    public void testDays() {
        Person person = new Person();
        Throwable e = assertThrows(TimeConflictException.class,
                ()->{person.isBusy(9,32,1,5);}
        );

        assertEquals("Day error.", e.getMessage());

    }

//meeting
    @Test
    public void getMeeting() {
        Person person=new Person();
        try{
            person.getMeeting(6,31,0);
        }catch(Exception e) {
            assertEquals("Should not throw exception: ",e.getMessage());
        }

    }

//removemeeting
    @Test
    public void test_remove_meeting() {
        //adding an object
        Meeting mayday = new Meeting(10, 24, "May Day");
        Person person=new Person();
        try{
            person.addMeeting(mayday);
            //removing the object
            person.removeMeeting(10,24,0);

        }catch(Exception e) {
            assertEquals("Should not throw exception: ",e.getMessage());
        }

    }

    @Test
    public void noMeetingExists() {
        Person person=new Person();
        Throwable e = assertThrows(Exception.class,
                ()->{person.removeMeeting(2,21,0);});
        assertEquals("Index 0 out of bounds for length 0",e.getMessage());

    }

    @Test
    public void test_isbusy_overlap() {

        Person person = new Person();

        try {
            Boolean fixed = person.isBusy(3, 3, 9, 20);
            assertNotEquals( true, fixed);
        } catch(TimeConflictException e) {
            fail("Should not throw exception: " + e.getMessage());
        }

    }

    @Test
    public void hourError() {
        Person person = new Person();

        Throwable e = assertThrows(Exception.class,
                ()->{
            person.isBusy(3,3,0,26);
        });
        assertEquals("Illegal hour.",e.getMessage());

    }
}
