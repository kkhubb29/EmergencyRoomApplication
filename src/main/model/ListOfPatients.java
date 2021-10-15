package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// list of patients
public class ListOfPatients {
    private ArrayList<Patient> patients;

    // EFFECTS: list is empty
    public ListOfPatients() {
        patients = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: Patient p is added to the ListOfPatients
    public void addPatient(Patient p) {
        patients.add(p);
    }

    // REQUIRES: Patient p is a patient in the ListOfPatients
    // MODIFIES: this
    // EFFECTS: Patient p is removed from ListOfPatients
    public void removePatient(Patient p) {
        patients.remove(p);
    }

    // EFFECTS: Returns true if Patient p is a patient in the ListOfPatients
    //          and false otherwise
    public boolean contains(Patient p) {
        return patients.contains(p);
    }

    public ArrayList<Patient> getListOfPatients() {
        return patients;
    }

    // EFFECTS: Sorts list of patients in order of score
    //          orders the highest score to the lowest score
    public void getListOfPatientsSorted() {
        Collections.sort(patients, new Comparator<Patient>() {
            public int compare(Patient p1, Patient p2) {
                return p1.getScore() > p2.getScore() ? -1 : 1;
            }
        });
    }

    // EFFECTS: If the patient is in ListOfPatients returns the index of
    //          given patientName and returns null otherwise
    public Patient findPatient(String patientName) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getPatientName().equals(patientName)) {
                return patients.get(i);
            }
        }

        return null;
    }

    // REQUIRES: patientNum is from ListOfPatient
    // EFFECTS: Returns the patient of the given patientNum from ListOfPatients
    public Patient findPatientByIndex(int patientNum) {
        return patients.get(patientNum);
    }

}
