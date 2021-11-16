package ui;

import model.ListOfPatients;
import model.Patient;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

// the GUI for the ER Patients triage App
public class App extends JFrame implements ActionListener {

    private static final String JSON_STORE = "./data/listOfPatients.json";

    private ListOfPatients erPatients;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    protected JButton loadButton;
    protected JButton saveButton;
    protected JButton addPatientButton;
    protected JButton assignButton;
    protected JButton removeButton;

    protected PatientsTable patients;

    // EFFECTS: initializes the app
    public App() throws FileNotFoundException {
        erPatients = new ListOfPatients("ER Patients");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        Patient p1 = new Patient("troy");
        Patient p2 = new Patient("fred");
        erPatients.addPatient(p1);
        erPatients.addPatient(p2);
    }

    // EFFECTS: Add the main panel to a container
    public void addPanelToContainer(Container pane) {

        // EFFECTS: creates two sub panels and one main one
        JPanel buttonsPanel = new JPanel();
        JPanel tablePanel = new JPanel();
        JPanel mainPanel = new JPanel();

        // EFFECTS: sets the layout on the mainPanel to be a vertical box layout

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // EFFECTS: builds the buttons sub panel
        // EFFECTS: creates the buttons, listeners and tooltips for the buttonsPanel
        createAddPatientButton();
        createLoadPatientButton();
        createSavePatientButton();
        createAssignPatientButton();
        createRemovePatientButton();

        createActionListeners();

        createButtonToolTips();

        // EFFECTS: adds the buttons to the buttonsPanel
        buttonsPanel.add(addPatientButton);
        buttonsPanel.add(assignButton);
        buttonsPanel.add(removeButton);
        buttonsPanel.add(loadButton);
        buttonsPanel.add(saveButton);

        // EFFECTS: builds the table sub panel

        // EFFECTS: constructs a new table of patients
        patients = new PatientsTable(erPatients);

        // EFFECTS: adds the table of patients to the tablePanel
        tablePanel.add(patients);

        // EFFECTS: builds the main panel by adding the two subpanels to it

        mainPanel.add(tablePanel);
        mainPanel.add(buttonsPanel);

        // EFFECTS: adds the main panel to the container
        pane.add(mainPanel);

    }


    // EFFECTS: builds the add patient button
    public void createAddPatientButton() {
        addPatientButton = new JButton("Add Patient");
        addPatientButton.setVerticalTextPosition(AbstractButton.CENTER);
        addPatientButton.setHorizontalTextPosition(AbstractButton.LEADING);
        addPatientButton.setMnemonic(KeyEvent.VK_A);
        addPatientButton.setActionCommand("Add Patient");
    }

    // EFFECTS: builds the remove patient button
    public void createRemovePatientButton() {
        removeButton = new JButton("Remove Patient");
        removeButton.setVerticalTextPosition(AbstractButton.CENTER);
        removeButton.setHorizontalTextPosition(AbstractButton.LEADING);
        removeButton.setMnemonic(KeyEvent.VK_R);
        removeButton.setActionCommand("Remove Patient");
    }

    // EFFECTS: builds the assign patient button
    public void createAssignPatientButton() {
        assignButton = new JButton("Assign");
        assignButton.setVerticalTextPosition(AbstractButton.CENTER);
        assignButton.setHorizontalTextPosition(AbstractButton.LEADING);
        assignButton.setMnemonic(KeyEvent.VK_G);
        assignButton.setActionCommand("Assign");
    }

    // EFFECTS: builds the save patients button
    public void createSavePatientButton() {
        saveButton = new JButton("Save");
        saveButton.setVerticalTextPosition(AbstractButton.CENTER);
        saveButton.setHorizontalTextPosition(AbstractButton.LEADING);
        saveButton.setMnemonic(KeyEvent.VK_S);
        saveButton.setActionCommand("Save");
    }

    // EFFECTS: builds the load patient button
    public void createLoadPatientButton() {
        loadButton = new JButton("Load");
        loadButton.setVerticalTextPosition(AbstractButton.CENTER);
        loadButton.setHorizontalTextPosition(AbstractButton.LEADING);
        loadButton.setMnemonic(KeyEvent.VK_L);
        loadButton.setActionCommand("Load");
    }

    // EFFECTS: builds text that appears when user hovers over buttons
    public void createButtonToolTips() {
        addPatientButton.setToolTipText("Click to add a patient to the list");
        removeButton.setToolTipText("Click to remove a patient from the list");
        saveButton.setToolTipText("Click to save list");
        loadButton.setToolTipText("Click to load list");
    }

    // EFFECTS: creates action listeners for each button
    public void createActionListeners() {
        addPatientButton.addActionListener(this);
        loadButton.addActionListener(this);
        saveButton.addActionListener(this);
        assignButton.addActionListener(this);
        removeButton.addActionListener(this);
    }

    // EFFECTS: creates the GUI and displays it to the user
    private static void createAndShowGUI() throws FileNotFoundException {

        try {
            JFrame frame = new JFrame("ER Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            App erPatients = new App();
            erPatients.addPanelToContainer(frame);

            frame.pack();
            frame.setVisible(true);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // EFFECTS: runs the response to when each button is clicked
    @Override
    public void actionPerformed(ActionEvent ae) {
        if ("Add Patient".equals(ae.getActionCommand())) {
            doAddPatient();
        } else if ("Load".equals(ae.getActionCommand())) {
            doLoadListOfPatients();
        } else if ("Save".equals(ae.getActionCommand())) {
            doSaveListOfPatient();
        } else if ("Assign".equals(ae.getActionCommand())) {
            doAssignPatient();
        } else if ("Remove Patient".equals(ae.getActionCommand())) {
            doRemovePatient();
        }
    }

    // MODIFIES: this
    // EFFECTS: conducts adding a patient to the list
    public void doAddPatient() {
        AddPatientDialog dlg = new AddPatientDialog(this);
        dlg.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        Patient results = dlg.run();
        System.out.println(results.getPatientName());
        erPatients.addPatient(results);
        patients.fireTableDataChanged();
    }

    // MODIFIES: this
    // EFFECTS: conducts removing a patient from the list
    public void doRemovePatient() {
        RemovePatientDialog dlg = new RemovePatientDialog(this);
        dlg.setLayout(new FlowLayout());
        String[] results = dlg.run();
        erPatients.removePatient(erPatients.findPatient(results[0]));
        patients.fireTableDataChanged();
    }

    // MODIFIES: this
    // EFFECTS: conducts assigning a patient
    public void doAssignPatient() {
        AssignPatientDialog dlg = new AssignPatientDialog(this);
        dlg.setLayout(new FlowLayout());
        String[] results = dlg.run();
        erPatients.findPatient(results[0]).setAssignment(results[1]);
        patients.fireTableDataChanged();
    }

    // EFFECTS: saves the list of patients to files
    public void doSaveListOfPatient() {
        try {
            jsonWriter.open();
            jsonWriter.write(erPatients);
            jsonWriter.close();
            patients.fireTableDataChanged();
            System.out.println("Saved " + erPatients.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads list of patients from file
    public void doLoadListOfPatients() {
        try {
            erPatients = jsonReader.read();
            patients.fireTableDataChanged();
            System.out.println("Loaded " + erPatients.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}