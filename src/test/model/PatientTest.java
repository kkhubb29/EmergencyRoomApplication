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
        assertEquals(5, testPatient.getAge());
        assertEquals(0, testPatient.getPain());
        assertEquals("n", testPatient.getTroubleBreathing());
        assertEquals("n", testPatient.getChestPain());
        assertEquals("n", testPatient.getBleeding());
        assertEquals("n", testPatient.getNauseous());
        assertEquals("n", testPatient.getBrokenBone());
        assertEquals("n", testPatient.getHeadInjury());
        assertEquals("n", testPatient.getPregnant());
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

    @Test
    public void testSetScore() {
        testPatient.setScore(9);
        assertEquals(9, testPatient.getScore());
    }

    @Test
    public void testSetAge() {
        testPatient.setAge(8);
        assertEquals(8, testPatient.getAge());
    }

    @Test
    public void testSetPain() {
        testPatient.setPain(8);
        assertEquals(8, testPatient.getPain());
    }

    @Test
    public void testSetTroubleBreathing() {
        testPatient.setTroubleBreathing("y");
        assertEquals("y", testPatient.getTroubleBreathing());
    }

    @Test
    public void testSetChestPain() {
        testPatient.setChestPain("y");
        assertEquals("y", testPatient.getChestPain());
    }

    @Test
    public void testSetBleeding() {
        testPatient.setBrokenBone("y");
        assertEquals("y", testPatient.getBrokenBone());
    }

    @Test
    public void testSetNauseous() {
        testPatient.setNauseous("y");
        assertEquals("y", testPatient.getNauseous());
    }

    @Test
    public void testSetBrokenBone() {
        testPatient.setBrokenBone("y");
        assertEquals("y", testPatient.getBrokenBone());
    }

    @Test
    public void testSetHeadInjury() {
        testPatient.setHeadInjury("y");
        assertEquals("y", testPatient.getHeadInjury());
    }

    @Test
    public void testSetPregnant() {
        testPatient.setPregnant("y");
        assertEquals("y", testPatient.getPregnant());
    }

    @Test
    public void testDealWithYOrNYesValue() {
        testPatient.setTroubleBreathing("y");
        assertTrue(testPatient.dealWithYOrN(testPatient.getTroubleBreathing()));
    }

    @Test
    public void testDealWithYOrNNoValue() {
        testPatient.setTroubleBreathing("n");
        assertFalse(testPatient.dealWithYOrN(testPatient.getTroubleBreathing()));
    }

    @Test
    public void testCalculateScoreAllTrue() {
        testPatient.setAge(1);
        testPatient.setPain(4);
        testPatient.setTroubleBreathing("y");
        testPatient.setChestPain("y");
        testPatient.setBleeding("y");
        testPatient.setNauseous("y");
        testPatient.setBrokenBone("y");
        testPatient.setHeadInjury("y");
        testPatient.setPregnant("y");

        assertEquals(67, testPatient.calculateScore());
        assertNotEquals(41, testPatient.calculateScore());
    }

    @Test
    public void testCalculateScoreAllFalse() {
        testPatient.setAge(1);
        testPatient.setPain(4);
        testPatient.setTroubleBreathing("n");
        testPatient.setChestPain("n");
        testPatient.setBleeding("n");
        testPatient.setNauseous("n");
        testPatient.setBrokenBone("n");
        testPatient.setHeadInjury("n");
        testPatient.setPregnant("n");

        assertEquals(7, testPatient.calculateScore());
        assertNotEquals(37, testPatient.calculateScore());
    }

}
