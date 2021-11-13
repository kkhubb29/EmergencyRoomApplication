package persistence;

import model.ListOfPatients;
import model.Patient;

import java.awt.geom.PathIterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkPatient(String name, int score, String assignment, String troubleBreathing, String chestPain,
                                String bleeding, String nauseous, String headInjury,
                                String pregnant, Patient p) {
        assertEquals(name, p.getPatientName());
        assertEquals(score, p.getScore());
        assertEquals(assignment, p.getAssignment());
        assertEquals(troubleBreathing, p.getTroubleBreathing());
        assertEquals(chestPain, p.getChestPain());
        assertEquals(bleeding, p.getBleeding());
        assertEquals(nauseous, p.getNauseous());
        assertEquals(headInjury, p.getHeadInjury());
        assertEquals(pregnant, p.getPregnant());

    }
}