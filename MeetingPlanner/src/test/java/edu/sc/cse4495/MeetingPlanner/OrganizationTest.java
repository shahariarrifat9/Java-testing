package edu.sc.cse4495.MeetingPlanner;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;



public class OrganizationTest {

    @Test
    public void TestGetRoom_Valid () throws Exception{
        Organization O1 = new Organization();
        var x = O1.getRoom("2A01"); //inputs
        assertEquals("2A01", x.getID());
    }


    @Test
    public void TestGetRoom_inValid (){
        Organization O1 = new Organization();
        try{
            O1.getRoom("3S21");
        } catch (Exception e){
            assertEquals("Requested room does not exist", e.getMessage());
        }
    }


    @Test
    public void TestGetEmployee_valid() throws Exception{
        Organization O2 = new Organization();
        var x = O2.getEmployee("Greg Gay");
        assertEquals("Greg Gay", x.getName());
    }


    @Test
    public void TestGetEmployee_inValid() throws Exception{
        Organization O3 =  new Organization();
        try{
            O3.getEmployee("Sharita Rahman");
        } catch (Exception e){
            assertEquals("Requested employee does not exist", e.getMessage());
        }
    }
}

