package persistence;

import model.ListOfPatients;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Patient;
import org.json.*;

// represents a  reader that reads list of patients from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads list of patient from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ListOfPatients read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseListOfPatients(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses list of patients from JSON object and returns it
    private ListOfPatients parseListOfPatients(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        ListOfPatients lp = new ListOfPatients(name);
        addPatients(lp, jsonObject);
        return lp;
    }

    // MODIFIES: lp
    // EFFECTS: parses patients from JSON object and adds them to list of patients
    private void addPatients(ListOfPatients lp, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("patients");
        for (Object json : jsonArray) {
            JSONObject nextPatient = (JSONObject) json;
            addPatient(lp, nextPatient);
        }
    }

    // MODIFIES: lp
    // EFFECTS: parses patient from JSON object and adds it to list of patients
    private void addPatient(ListOfPatients lp, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Patient patient = new Patient(name);
        lp.addPatient(patient);
    }
}

