package model;

//represents a patient with name, assignment, and score
public class Patient {
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
        troubleBreathing = "n";
        chestPain = "n";
        bleeding = "n";
        nauseous = "n";
        brokenBone = "n";
        headInjury = "n";
        pregnant = "n";
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
    }

    // EFFECTS: score is updated to scorePatient
    public void setScore(int scorePatient) {
        score = scorePatient;
    }

    // EFFECTS: age is updated to agePatient
    public void setAge(int agePatient) {
        this.age = agePatient;
    }

    // EFFECTS: pain is updated to painPatient
    public void setPain(int painPatient) {
        this.pain = painPatient;
    }

    // EFFECTS: troubleBreathing is updated to troubleBreathingPatient
    public void setTroubleBreathing(String troubleBreathingPatient) {
        this.troubleBreathing = troubleBreathingPatient;
    }

    // EFFECTS: chestPain is updated to chestPainPatient
    public void setChestPain(String chestPainPatient) {
        this.chestPain = chestPainPatient;
    }

    // EFFECTS: bleeding is updated to bleedingPatient
    public void setBleeding(String bleedingPatient) {
        this.bleeding = bleedingPatient;
    }

    // EFFECTS: nauseous is updated to nauseousPatient
    public void setNauseous(String nauseousPatient) {
        this.nauseous = nauseousPatient;
    }

    // EFFECTS: brokenBone is updated to brokenBonePatient
    public void setBrokenBone(String brokenBonePatient) {
        this.brokenBone = brokenBonePatient;
    }

    // EFFECTS: headInjury is updated to headInjuryPatient
    public void setHeadInjury(String headInjuryPatient) {
        this.headInjury = headInjuryPatient;
    }

    // EFFECTS: pregnant is updated to pregnantPatient
    public void setPregnant(String pregnantPatient) {
        this.pregnant = pregnantPatient;
    }

    // EFFECTS: returns true if string is y and false otherwise
    public boolean dealWithYOrN(String yesOrNo) {
        if (yesOrNo.equals("y")) {
            return true;
        }
        return false;
    }

    // EFFECTS:
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


}
