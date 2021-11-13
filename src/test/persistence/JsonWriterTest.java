package persistence;

import model.ListOfPatients;
import model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonWriterTest extends JsonTest {

    private ListOfPatients testListOfPatients;
    Patient p1;
    Patient p2;

    @BeforeEach
    void runBefore() {
        testListOfPatients = new ListOfPatients("test list");
        p1 = new Patient("Jane");
        p1.setAssignment("waiting room");
        p2 = new Patient("May");
        p2.setAssignment("doctor");
        p2.setScore(23);
        p2.setTroubleBreathing("y");
        p2.setChestPain("n");
        p2.setBleeding("y");
        p2.setNauseous("y");
        p2.setHeadInjury("y");
        p2.setPregnant("n");
    }

    @Test
    void testWriterInvalidFile() {
        try {
            ListOfPatients lp = new ListOfPatients("ER Patients");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyListOfPatients() {
        try {
            ListOfPatients lp = new ListOfPatients("ER Patients");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyListOfPatients.json");
            writer.open();
            writer.write(lp);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyListOfPatients.json");
            lp = reader.read();
            assertEquals("ER Patients", lp.getName());
            assertEquals(0, lp.numPatients());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralListOfPatients() {
        try {
            ListOfPatients lp = new ListOfPatients("ER Patients");
            lp.addPatient(p1);
            lp.addPatient(p2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralListOfPatients.json");
            writer.open();
            writer.write(lp);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralListOfPatients.json");
            lp = reader.read();
            assertEquals("ER Patients", lp.getName());
            ArrayList<Patient> patients = lp.getListOfPatients();
            assertEquals(2, patients.size());
            checkPatient("Jane", 0, "waiting room", "not entered",
                    "not entered", "not entered", "not entered",
                    "not entered", "not entered", patients.get(0));
            checkPatient("May", 23, "doctor", "y", "n", "y",
                    "y", "y", "n", patients.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}