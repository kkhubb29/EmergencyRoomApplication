package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

// This class references code from this repo
// Link: https://github.students.cs.ubc.ca/CPSC210/AlarmSystem.git

/**
 * Unit tests for the Event class
 */
public class EventTest {
    private Event e;
    private Date d;
    private Object other;
    private String string;
    private String description;

    //NOTE: these tests might fail if time at which line (2) below is executed
    //is different from time that line (1) is executed.  Lines (1) and (2) must
    //run in same millisecond for this test to make sense and pass.

    @BeforeEach
    public void runBefore() {
        e = new Event("Added patient");   // (1)
        d = Calendar.getInstance().getTime();   // (2)
    }

    @Test
    public void testEvent() {
        assertEquals("Added patient", e.getDescription());
        //System.out.println(d.toString());
        //System.out.println(e.getDate());
        assertEquals(d.toString(), e.getDate().toString());
    }

    @Test
    public void testToString() {
        assertEquals(d.toString() + "\n" + "Added patient", e.toString());
    }

    @Test
    public void testEquals() {
        other = null;
        assertFalse(e.equals(other));

        string = "";
        assertFalse(e.equals(string));
    }

    @Test
    public void testHashCode() {
        description = "Added patient";
        assertEquals((13 * d.hashCode() + description.hashCode()), e.hashCode());
    }

}


