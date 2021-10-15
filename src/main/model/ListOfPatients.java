package model;

import java.util.ArrayList;
import java.util.List;

// list of patients
public class ListOfPatients {
    private ArrayList<Patient> patients;

    public ListOfPatients() {
        patients = new ArrayList<>();
    }

    public void addPatient(Patient p) {
        patients.add(p);
        /*for (int x = 0; x < p.getScore(); x++) {
            patients.add(p);
        }*/
    }

    public void removePatient(Patient p) {
        patients.remove(p);
    }

    public boolean contains(Patient p) {
        return patients.contains(p);
    }

    public ArrayList<Patient> getListOfPatients() {
        return patients;
    }

    public Patient findPatient(String patientName) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getPatientName() == patientName) {
                return patients.get(i);
            }
        }

        return null;
    }

    public Patient findPatientByIndex(int patientNum) {
        return patients.get(patientNum);
    }

}
