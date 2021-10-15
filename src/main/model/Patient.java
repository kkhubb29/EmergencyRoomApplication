package model;

//represents a patient with name and assignment
public class Patient {
    private String patientName;
    private int score = 0;
    private String assignment;


    public Patient(String patientName) {
        this.patientName = patientName;
        score = 0;
        assignment = "waiting room";
    }

    public String getPatientName() {
        return patientName;
    }

    public int getScore() {
        return score;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignmentPatient) {
        assignment = assignmentPatient;
    }

}
