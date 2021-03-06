package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// test for ListOfPatient
class ListOfPatientsTest {
    private ListOfPatients testListOfPatients;
    Patient p1;
    Patient p2;
    Patient p3;
    Patient p4;
    Patient p5;

    @BeforeEach
    void runBefore() {
        testListOfPatients = new ListOfPatients("test list");
        p1 = new Patient("Jane");
        p2 = new Patient("May");
        p3 = new Patient("Selina");
        p4 = new Patient("Greg");
        p5 = new Patient("Henry");
    }

    @Test
    public void testAddPatient() {
        testListOfPatients.addPatient(p1);
        assertTrue(testListOfPatients.contains(p1));
    }

    @Test
    public void testContainsOnePatientList() {
        assertFalse(testListOfPatients.contains(p1));
        testListOfPatients.addPatient(p1);
        assertTrue(testListOfPatients.contains(p1));
    }

    @Test
    public void testContainsManyPatientsList() {
        testListOfPatients.addPatient(p1);
        testListOfPatients.addPatient(p2);
        testListOfPatients.addPatient(p3);
        assertTrue(testListOfPatients.contains(p2));
        assertFalse(testListOfPatients.contains(p4));
    }

    @Test
    public void testRemovePatient() {
        testListOfPatients.addPatient(p1);
        testListOfPatients.removePatient(p1);
        assertFalse(testListOfPatients.contains(p1));
    }

    @Test
    public void testRemovePatientManyPatientList() {
        testListOfPatients.addPatient(p1);
        testListOfPatients.addPatient(p2);
        testListOfPatients.addPatient(p3);
        testListOfPatients.removePatient(p2);
        assertFalse(testListOfPatients.contains(p2));
    }

    @Test
    public void testFindPatient() {
        testListOfPatients.addPatient(p1);
        testListOfPatients.addPatient(p2);
        testListOfPatients.addPatient(p3);
        testListOfPatients.addPatient(p4);
        testListOfPatients.addPatient(p5);
        assertEquals(p4, testListOfPatients.findPatient("Greg"));
        assertNotEquals(p5, testListOfPatients.findPatient("Greg"));
    }

    @Test
    public void testFindPatientNoPatient() {
        testListOfPatients.addPatient(p1);
        testListOfPatients.addPatient(p2);
        testListOfPatients.addPatient(p3);
        testListOfPatients.addPatient(p4);
        testListOfPatients.addPatient(p4);
        assertEquals(null, testListOfPatients.findPatient("Nancy"));
    }

    @Test
    public void testFindPatientByInt() {
        testListOfPatients.addPatient(p1);
        testListOfPatients.addPatient(p2);
        testListOfPatients.addPatient(p3);
        testListOfPatients.addPatient(p4);
        testListOfPatients.addPatient(p4);
        assertEquals(p4, testListOfPatients.findPatientByIndex(3));
    }

    @Test
    public void testGetListOfPatients() {
        testListOfPatients.addPatient(p1);
        ArrayList<Patient> testPatients = testListOfPatients.getListOfPatients();
        assertEquals(testPatients.get(0), p1);
    }

   @Test
    public void testGetListOfPatientsSorted() {
        testListOfPatients.addPatient(p1);
        p1.setScore(8);
        testListOfPatients.addPatient(p2);
        p2.setScore(7);
        testListOfPatients.addPatient(p3);
        p3.setScore(10);
        testListOfPatients.addPatient(p4);
        p4.setScore(6);
        testListOfPatients.addPatient(p4);
        p5.setScore(5);
        testListOfPatients.getListOfPatientsSorted();
        ArrayList<Patient> testPatients = testListOfPatients.getListOfPatients();
        assertEquals(p3.getPatientName(), testPatients.get(0).getPatientName());
    }

    @Test
    public void testGetName() {
        assertEquals("test list", testListOfPatients.getName());
    }

    @Test
    public void testNumPatients() {
        assertEquals(0, testListOfPatients.numPatients());
        testListOfPatients.addPatient(p1);
        testListOfPatients.addPatient(p2);
        testListOfPatients.addPatient(p3);
        assertEquals(3, testListOfPatients.numPatients());
    }
}