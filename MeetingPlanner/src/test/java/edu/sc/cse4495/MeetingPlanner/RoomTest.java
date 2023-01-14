package edu.sc.cse4495.MeetingPlanner;

import org.junit.Test;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoomTest {
    // Add test methods here.
    // You are not required to write tests for all classes.

    // Add Meeting




    @Test
    public void meetingAdd() {

        Room room = new Room("2A01");
        Meeting fixed = new Meeting(5, 1, "May Day");
        try {
            room.addMeeting(fixed);
        } catch(TimeConflictException e) {
            fail(e.getMessage());
        }
    }

    //Is Busy

    @Test
    public void isBusy_Busy(){
        Room room = new Room("2A01");
        try{
            Boolean busy = room.isBusy(4, 31, 0, 5);

            assertTrue("Room is busy." ,busy);
        }
        catch(TimeConflictException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void isBusy_open(){
        Room R1 = new Room("2A03");
        try{
            Boolean free = R1.isBusy(7, 15, 10, 14);

            assertFalse("Room is free." ,free);
        }
        catch(Exception e){
            fail(e.getMessage());
        }
    }

    // Getting Meeting

    @Test
    public void getMeeting(){
        Room room = new Room("2A01");
        try{
            room.getMeeting(6, 31, 0);
        }
        catch(Exception e){
            fail(e.getMessage());
        }
    }



    // Remove Meeting

    @Test
    public void removeMeeting(){
        Room room = new Room("A123");
        try{
            room.removeMeeting(6, 31, 0);
        }
        catch(Exception e){
            fail(e.getMessage());
        }
    }



}
