package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// tests for Patient
public class PatientTest {
    private Patient testPatient;

    @BeforeEach
    void runBefore() {
        testPatient = new Patient("Selena");
    }

    @Test
    public void testConstructor() {
        assertEquals("Selena", testPatient.getPatientName());
        assertEquals(0, testPatient.getScore());
        assertEquals("waiting room", testPatient.getAssignment());
    }


    @Test
    public void testChangePatientAssignmentToDoctor() {
        testPatient.setAssignment("Doctor");
        assertEquals("Doctor", testPatient.getAssignment());
    }

    @Test
    public void testChangePatientAssignmentToNursePractitioner() {
        testPatient.setAssignment("Nurse Practitioner");
        assertEquals("Nurse Practitioner", testPatient.getAssignment());
    }

}
