package persistence;

import model.ListOfPatients;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Patient;
import org.json.*;

// This class references code from this repo
// Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

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

    /*// EFFECTS: reads list of patient from file and returns it;
    // throws IOException if an error occurs reading data from file
    public void read(ListOfPatients listOfPatients) throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        parseListOfPatients(jsonObject, listOfPatients);
        return;
    }*/

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

    /*// EFFECTS: parses list of patients from JSON object and returns it
    private ListOfPatients parseListOfPatients(JSONObject jsonObject, ListOfPatients lp) {
        String name = jsonObject.getString("name");
        addPatients(lp, jsonObject);
        return lp;
    }*/

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
        int score = jsonObject.getInt("score");
        String assignment = jsonObject.getString("assignment");
        String troubleBreathing = jsonObject.getString("trouble breathing");
        String chestPain = jsonObject.getString("chest pain");
        String bleeding = jsonObject.getString("bleeding");
        String nauseous = jsonObject.getString("nauseous");
        String headInjury = jsonObject.getString("head injury");
        String pregnant = jsonObject.getString("pregnant");
        Patient patient = new Patient(name);
        patient.setScore(score);
        patient.setAssignment(assignment);
        patient.setTroubleBreathing(troubleBreathing);
        patient.setChestPain(chestPain);
        patient.setBleeding(bleeding);
        patient.setNauseous(nauseous);
        patient.setHeadInjury(headInjury);
        patient.setPregnant(pregnant);
        lp.addPatient(patient);
    }
}

