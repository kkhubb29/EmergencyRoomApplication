package ui;

import model.ListOfPatients;
import model.Patient;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

// the GUI for the ER Patients triage App
public class RunApp extends JFrame implements ActionListener {

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
    public RunApp() throws FileNotFoundException {
        erPatients = new ListOfPatients("ER Patients");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    // EFFECTS: Add the main panel to a container
    public void addPanelToContainer(Container pane) throws IOException {

        JPanel logoPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        JPanel tablePanel = new JPanel();
        JPanel mainPanel = new JPanel();


        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        BufferedImage logo = ImageIO.read(new File("./data/er logo.png"));
        JLabel picLabel = new JLabel(new ImageIcon(logo));
        logoPanel.add(picLabel);


        createAllButton();
        createActionListeners();
        createButtonToolTips();

        buttonsPanel.add(addPatientButton);
        buttonsPanel.add(assignButton);
        buttonsPanel.add(removeButton);
        //buttonsPanel.add(loadButton);
        buttonsPanel.add(saveButton);

        patients = new PatientsTable(erPatients);

        tablePanel.add(patients);

        mainPanel.add(logoPanel);
        mainPanel.add(tablePanel);
        mainPanel.add(buttonsPanel);

        pane.add(mainPanel);

    }

    // EFFECTS: builds all the buttons
    public void createAllButton() {
        createAddPatientButton();
        //createLoadPatientButton();
        createSavePatientButton();
        createAssignPatientButton();
        createRemovePatientButton();
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
        assignButton = new JButton("Assign Patient");
        assignButton.setVerticalTextPosition(AbstractButton.CENTER);
        assignButton.setHorizontalTextPosition(AbstractButton.LEADING);
        assignButton.setMnemonic(KeyEvent.VK_P);
        assignButton.setActionCommand("Assign");
    }

    // EFFECTS: builds the save patients button
    public void createSavePatientButton() {
        saveButton = new JButton("Save Patients");
        saveButton.setVerticalTextPosition(AbstractButton.CENTER);
        saveButton.setHorizontalTextPosition(AbstractButton.LEADING);
        saveButton.setMnemonic(KeyEvent.VK_S);
        saveButton.setActionCommand("Save");
    }

    /*// EFFECTS: builds the load patient button
    public void createLoadPatientButton() {
        loadButton = new JButton("Load Patients");
        loadButton.setVerticalTextPosition(AbstractButton.CENTER);
        loadButton.setHorizontalTextPosition(AbstractButton.LEADING);
        loadButton.setMnemonic(KeyEvent.VK_L);
        loadButton.setActionCommand("Load");
    }*/

    // EFFECTS: builds text that appears when user hovers over buttons
    public void createButtonToolTips() {
        addPatientButton.setToolTipText("Click to add a patient to the list");
        removeButton.setToolTipText("Click to remove a patient from the list");
        saveButton.setToolTipText("Click to save list of patients");
        //loadButton.setToolTipText("Click to load list of patients");
    }

    // EFFECTS: creates action listeners for each button
    public void createActionListeners() {
        addPatientButton.addActionListener(this);
        //loadButton.addActionListener(this);
        saveButton.addActionListener(this);
        assignButton.addActionListener(this);
        removeButton.addActionListener(this);
    }

    // EFFECTS: creates the GUI and displays it to the user
    private static void createAndShowGUI() throws FileNotFoundException {

        try {

            JFrame frame = new JFrame("ER Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            RunApp erPatients = new RunApp();
            erPatients.doLoadListOfPatients();

            erPatients.addPanelToContainer(frame);

            frame.pack();
            frame.setVisible(true);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        } catch (IOException e) {
            e.printStackTrace();
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
        dlg.setLayout(new FlowLayout());
        Patient results = dlg.run();
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
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads list of patients from file
    public void doLoadListOfPatients() {
        try {
            StartLoadDialog dlg = new StartLoadDialog(this);
            boolean load = dlg.run();
            if (load) {
                erPatients = jsonReader.read();
            }
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}