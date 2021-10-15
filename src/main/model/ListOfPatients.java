package model;

import java.util.ArrayList;

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

    // EFFECTS: If the patient is in ListOfPatients returns the patient of
    //          given patientName and returns null otherwise
    public Patient findPatient(String patientName) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getPatientName() == patientName) {
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
