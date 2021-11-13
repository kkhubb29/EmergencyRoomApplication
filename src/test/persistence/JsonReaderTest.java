package persistence;

import model.ListOfPatients;
import model.Patient;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ListOfPatients lp = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyListOfPatients() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyListOfPatients.json");
        try {
            ListOfPatients lp = reader.read();
            assertEquals("ER Patients", lp.getName());
            assertEquals(0, lp.numPatients());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralListOfPatients() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralListOfPatients.json");
        try {
            ListOfPatients lp = reader.read();
            assertEquals("ER Patients", lp.getName());
            List<Patient> patients = lp.getPatients();
            assertEquals(2, patients.size());
            checkPatient("Jane", 0, "waiting room", "not entered",
                    "not entered", "not entered", "not entered",
                    "not entered", "not entered", patients.get(0));
            checkPatient("May", 23, "doctor", "y", "n", "y",
                    "y",  "y", "n", patients.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}