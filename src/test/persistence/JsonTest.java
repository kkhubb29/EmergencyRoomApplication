package persistence;

import model.ListOfPatients;
import model.Patient;

import java.awt.geom.PathIterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkPatient(String name, Patient p) {
        assertEquals(name, p.getPatientName());
    }
}
