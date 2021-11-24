package model;

import org.json.JSONObject;
import persistence.Writable;

//represents a patient with name, assignment, and score
public class Patient implements Writable {
    private String patientName;
    private int score = 0;
    private String assignment;
    private int age;
    private int pain;
    private String troubleBreathing;
    private String chestPain;
    private String bleeding;
    private String nauseous;
    private String brokenBone;
    private String headInjury;
    private String pregnant;

    private final int patientAgeScore = 3;
    private final int troubleBreathingScore = 10;
    private final int chestPainScore = 10;
    private final int bleedingScore = 10;
    private final int nauseousScore = 10;
    private final int brokenBoneScore = 10;
    private final int headInjuryScore = 10;
    private final int pregnantScore = 10;

    // REQUIRES: patientName has a non-zero length
    // EFFECTS: name of patient is set to patientName; score is initialized
    //          at zero; assignment is set to "waiting room"
    public Patient(String patientName) {
        this.patientName = patientName;
        score = 0;
        assignment = "waiting room";
        age = 5;
        pain = 0;
        troubleBreathing = "not entered";
        chestPain = "not entered";
        bleeding = "not entered";
        nauseous = "not entered";
        brokenBone = "not entered";
        headInjury = "not entered";
        pregnant = "not entered";
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

    public int getAge() {
        return age;
    }

    public int getPain() {
        return pain;
    }

    public String getTroubleBreathing() {
        return troubleBreathing;
    }

    public String getChestPain() {
        return chestPain;
    }

    public String getBleeding() {
        return bleeding;
    }

    public String getNauseous() {
        return nauseous;
    }

    public String getBrokenBone() {
        return brokenBone;
    }

    public String getHeadInjury() {
        return headInjury;
    }

    public String getPregnant() {
        return pregnant;
    }

    // REQUIRES: assignmentPatient has a non-zero length
    // EFFECTS: assignment is updated to assignmentPatient
    public void setAssignment(String assignmentPatient) {
        assignment = assignmentPatient;
        EventLog.getInstance().logEvent(new Event(this.getPatientName() + " was assigned to "
                + assignmentPatient + "."));
    }

    // EFFECTS: score is updated to scorePatient
    public void setScore(int scorePatient) {
        score = scorePatient;
    }

    // EFFECTS: age is updated to agePatient
    public void setAge(int agePatient) {
        this.age = agePatient;
    }

    // REQUIRES: painPatient is a number between 0 and 10
    // EFFECTS: pain is updated to painPatient
    public void setPain(int painPatient) {
        this.pain = painPatient;
    }

    // REQUIRES: troubleBreathingPatient has a non-zero length
    // EFFECTS: troubleBreathing is updated to troubleBreathingPatient
    public void setTroubleBreathing(String troubleBreathingPatient) {
        this.troubleBreathing = troubleBreathingPatient;
    }

    // REQUIRES: chestPainPatient has a non-zero length
    // EFFECTS: chestPain is updated to chestPainPatient
    public void setChestPain(String chestPainPatient) {
        this.chestPain = chestPainPatient;
    }

    // REQUIRES: bleedingPatient has a non-zero length
    // EFFECTS: bleeding is updated to bleedingPatient
    public void setBleeding(String bleedingPatient) {
        this.bleeding = bleedingPatient;
    }

    // REQUIRES: nauseousPatient has a non-zero length
    // EFFECTS: nauseous is updated to nauseousPatient
    public void setNauseous(String nauseousPatient) {
        this.nauseous = nauseousPatient;
    }

    // REQUIRES: brokenBonePatient has a non-zero length
    // EFFECTS: brokenBone is updated to brokenBonePatient
    public void setBrokenBone(String brokenBonePatient) {
        this.brokenBone = brokenBonePatient;
    }

    // REQUIRES: headInjuryPatient has a non-zero length
    // EFFECTS: headInjury is updated to headInjuryPatient
    public void setHeadInjury(String headInjuryPatient) {
        this.headInjury = headInjuryPatient;
    }

    // REQUIRES: pregnantPatient has a non-zero length
    // EFFECTS: pregnant is updated to pregnantPatient
    public void setPregnant(String pregnantPatient) {
        this.pregnant = pregnantPatient;
    }

    // REQUIRES: yesOrNo has a non-zero length
    // EFFECTS: returns true if string is y and false otherwise
    public boolean dealWithYOrN(String yesOrNo) {
        if (yesOrNo.equals("y")) {
            return true;
        }
        return false;
    }

    // EFFECTS: returns calculated score
    public int calculateScore() {
        score = score + pain;
        if ((age > 80) || (age < 2)) {
            score = score + patientAgeScore;
        }
        if (dealWithYOrN(troubleBreathing)) {
            score = score + troubleBreathingScore;
        }
        if (dealWithYOrN(chestPain)) {
            score = score + chestPainScore;
        }
        if (dealWithYOrN(bleeding)) {
            score = score + bleedingScore;
        }
        if (dealWithYOrN(nauseous)) {
            score = score + nauseousScore;
        }
        if (dealWithYOrN(headInjury)) {
            score = score + headInjuryScore;
        }
        if (dealWithYOrN(pregnant)) {
            score = score + pregnantScore;
        }
        return score;
    }

    @Override
    // EFFECTS: creates fields for file
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", patientName);
        json.put("score", score);
        json.put("assignment", assignment);
        json.put("trouble breathing", troubleBreathing);
        json.put("chest pain", chestPain);
        json.put("bleeding", bleeding);
        json.put("nauseous", nauseous);
        json.put("head injury", headInjury);
        json.put("pregnant", pregnant);
        return json;
    }

}
