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
            ListOfPatients lp = new ListOfPatients("My work room");
            lp.addPatient(p1);
            lp.addPatient(p2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(lp);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            lp = reader.read();
            assertEquals("My work room", lp.getName());
            ArrayList<Patient> patients = lp.getListOfPatients();
            assertEquals(2, patients.size());
            checkPatient("Jane", patients.get(0));
            checkPatient("May", patients.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}