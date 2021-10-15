package ui;

import model.Patient;
import model.ListOfPatients;

import java.util.ArrayList;
import java.util.Scanner;

// This class references code from this repo
// Link: https://github.students.cs.ubc.ca/CPSC210/TellerApp.git

// Interface for ER Waiting Room application
public class ERWaitingRoomApp {
    private Scanner input;

    private ListOfPatients erPatients;
    Patient p1;

    // EFFECTS: runs ER Waiting Room application
    public ERWaitingRoomApp() {
        runIdentity();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runIdentity() {
        boolean keepGoing = true;
        String identity = null;

        init();

        while (keepGoing) {
            displayMenu();
            identity = input.next();
            identity = identity.toLowerCase();

            if (identity.equals("q")) {
                keepGoing = false;
            } else {
                processIdentity(identity);
            }

        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: initializes ListOfPatients
    private void init() {
        erPatients = new ListOfPatients();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    public void displayMenu() {
        System.out.println("\nWho are you?");
        System.out.println("Select from:");
        System.out.println("\tp -> patient");
        System.out.println("\te -> er coordinator");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: process user identity
    private void processIdentity(String identity) {
        if (identity.equals("p")) {
            runPatient();
        } else if (identity.equals("e")) {
            runERCoordinator();
        } else {
            System.out.println("Selection not valid");
        }
    }

    // MODIFIES: this
    // EFFECTS: conducts taking a patients name and adding
    //          them to the list
    private void runPatient() {
        System.out.println("Name?");
        String namePatient = input.next();
        p1 = new Patient(namePatient);
        displayAgeQuestion();
        displayPainQuestion();
        displayTroubleBreathingQuestion();
        displayChestPainQuestion();
        displayBleedingQuestion();
        displayNauseousQuestion();
        displayHeadInjuryQuestion();
        displayPregnantQuestion();
        p1.setScore(p1.calculateScore());
        erPatients.addPatient(p1);
        System.out.println("\nThank you for filling out the form we will be with you shortly!");
    }

    public void displayAgeQuestion() {
        System.out.println("Age?");
        int agePatient = input.nextInt();
        p1.setAge(agePatient);
    }

    public void displayPainQuestion() {
        System.out.println("What is your pain on a scale of 0-10?");
        int painPatient = input.nextInt();
        p1.setPain(painPatient);
    }

    public void displayTroubleBreathingQuestion() {
        System.out.println("Are you having trouble breathing (y/n)?");
        String troubleBreathingPatient = input.next();
        troubleBreathingPatient = troubleBreathingPatient.toLowerCase();
        p1.setTroubleBreathing(troubleBreathingPatient);
    }

    public void displayChestPainQuestion() {
        System.out.println("Are you experiencing chest pains (y/n)?");
        String chestPainPatient = input.next();
        chestPainPatient = chestPainPatient.toLowerCase();
        p1.setChestPain(chestPainPatient);
    }

    public void displayBleedingQuestion() {
        System.out.println("Are you bleeding (y/n)?");
        String bleedingPatient = input.next();
        bleedingPatient = bleedingPatient.toLowerCase();
        p1.setBleeding(bleedingPatient);
    }

    public void displayNauseousQuestion() {
        System.out.println("Are you nauseous (y/n)?");
        String nauseousPatient = input.next();
        nauseousPatient = nauseousPatient.toLowerCase();
        p1.setNauseous(nauseousPatient);
    }

    public void displayHeadInjuryQuestion() {
        System.out.println("Do you have a head injury (y/n)?");
        String headInjuryPatient = input.next();
        headInjuryPatient = headInjuryPatient.toLowerCase();
        p1.setHeadInjury(headInjuryPatient);
    }

    public void displayPregnantQuestion() {
        System.out.println("Are you pregnant (y/n)?");
        String pregnantPatient = input.next();
        pregnantPatient = pregnantPatient.toLowerCase();
        p1.setPregnant(pregnantPatient);
    }

    // MODIFIES: this
    // EFFECTS: process user input
    private void runERCoordinator() {
        boolean keepGoing = true;
        String command = null;

        while (keepGoing) {
            displayERCoordinator();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }

        }

        System.out.println("\nGoodbye!");
    }

    // EFFECTS: display menu of options to user
    public void displayERCoordinator() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add a patient");
        System.out.println("\tr -> remove a patient");
        System.out.println("\tv -> view list of patients");
        System.out.println("\ts -> assign a patient");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: process user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            doAddPatient();
        } else if (command.equals("r")) {
            doRemovePatient();
        } else if (command.equals("v")) {
            doViewList();
        } else if (command.equals("s")) {
            doAssignPatient();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: conducts adding a patient to the list
    private void doAddPatient() {
        System.out.println("What is the name of the patient you would like to add?");
        String namePatient = input.next();
        Patient p1 = new Patient(namePatient);
        erPatients.addPatient(p1);
    }

    // MODIFIES: this
    // EFFECTS: conducts removing a patient from the list
    private void doRemovePatient() {
        System.out.println("What is the name of the patient you would like to remove?");
        viewListOfPatients();
        String namePatient = input.next();
        erPatients.removePatient(erPatients.findPatient(namePatient));
        System.out.println(namePatient + " removed!");
        viewListOfPatients();
    }

    // EFFECTS: prints list of patients to the screen
    public void viewListOfPatients() {
        erPatients.getListOfPatientsSorted();
        ArrayList<Patient> patientsList = erPatients.getListOfPatients();
        for (int i = 0; i < patientsList.size(); i++) {
            int j = i + 1;
            System.out.println(j + " - " + patientsList.get(i).getPatientName() + ", "
                    + patientsList.get(i).getAssignment() + ", score:" + patientsList.get(i).getScore());
        }
    }

    // MODIFIES: this
    // EFFECTS: conducts printing a list of patient to the screen
    private void doViewList() {
        viewListOfPatients();
    }

    // MODIFIES: this
    // EFFECTS: conducts assigning a patient
    public void doAssignPatient() {
        System.out.println("What is the name of the patient you would like to assign?");
        viewListOfPatients();
        String namePatient = input.next();
        System.out.println("Where would you like to assign this patient?");
        displayAssignPatient();
        String assignmentPatient = input.next();
        erPatients.findPatient(namePatient).setAssignment(assignmentPatient);
        System.out.println(namePatient + " assignment has been changed to " + assignmentPatient + ":");
        viewListOfPatients();
    }

    // EFFECTS: displays menu of options to user
    public void displayAssignPatient() {
        System.out.println("\nSelect from:");
        System.out.println("\tdoctor");
        System.out.println("\tnurse practitioner");
        System.out.println("\twaiting room");
    }


}
