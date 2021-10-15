package ui;

import model.Patient;
import model.ListOfPatients;

import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
/*    private Patient patientName;
    private Patient patientAge;
    private Patient pain;
    private Patient troubleBreathing;
    private Patient chestPain;
    private Patient bleeding;
    private Patient nauseous;
    private Patient brokenBone;
    private Patient headInjury;
    private Patient pregnant;
    private Patient score;
    private Patient assignment;*/
    private Scanner input;

    private ListOfPatients erPatients;
    Patient p1;

    public Interface() {
        runIdentity();
    }

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

    private void init() {
        erPatients = new ListOfPatients();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    public void displayMenu() {
        System.out.println("\nWho are you?");
        System.out.println("Select from:");
        System.out.println("\tp -> patient");
        System.out.println("\te -> er coordinator");
        System.out.println("\tq -> quit");
    }


    private void processIdentity(String identity) {
        if (identity.equals("p")) {
            runPatient();
        } else if (identity.equals("e")) {
            runERCoordinator();
        } else {
            System.out.println("Selection not valid");
        }
    }

    private void runPatient() {
        System.out.println("Name?");
        String namePatient = input.next();
        p1 = new Patient(namePatient);
        erPatients.addPatient(p1);
        System.out.println("\nThank you for filling out the form we will be with you shortly!");
    }


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

    public void displayERCoordinator() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add a patient");
        System.out.println("\tr -> remove a patient");
        System.out.println("\tv -> view list of patients");
        System.out.println("\ts -> assign a patient");
        System.out.println("\tq -> quit");
    }

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

    private void doAddPatient() {
        System.out.println("What is the name of the patient you would like to add?");
        String namePatient = input.next();
        Patient p1 = new Patient(namePatient);
        erPatients.addPatient(p1);
    }

    private void doRemovePatient() {
        System.out.println("What is the number of the patient you would like to remove?");
        erPatients.viewListOfPatients();
        int numPatient = input.nextInt();
        erPatients.removePatient(erPatients.findPatientByIndex(numPatient));
        System.out.println("Patient " + numPatient + " removed!");
        erPatients.viewListOfPatients();
    }


    private void doViewList() {
        erPatients.viewListOfPatients();
    }

    public void doAssignPatient() {
        System.out.println("What is the number of the patient you would like to assign?");
        erPatients.viewListOfPatients();
        int numPatient = input.nextInt();
        System.out.println("Where would you like to assign this patient?");
        displayAssignPatient();
        String assignmentPatient = input.next();
        erPatients.findPatientByIndex(numPatient).setAssignment(assignmentPatient);
        System.out.println("Patient " + numPatient + " assignment changed to " + assignmentPatient + ":");
        erPatients.viewListOfPatients();
    }

    public void displayAssignPatient() {
        System.out.println("\nSelect from:");
        System.out.println("\tdoctor");
        System.out.println("\tnurse practitioner");
        System.out.println("\twaiting room");
    }



}
