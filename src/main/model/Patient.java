package model;

//represents a patient with name, assignment, and score
public class Patient {
    private String patientName;
    private int score = 0;
    private String assignment;

    // REQUIRES: patientName has a non-zero length
    // EFFECTS: name of patient is set to patientName; score is initialized
    //          at zero; assignment is set to "waiting room"
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

    // REQUIRES: assignmentPatient has a non-zero length
    // EFFECTS: assignment is updated to assignmentPatient
    public void setAssignment(String assignmentPatient) {
        assignment = assignmentPatient;
    }

}
