package ui;

import model.ListOfPatients;
import model.Patient;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

import static javax.swing.BoxLayout.PAGE_AXIS;

public class App extends JFrame implements ActionListener {

    private static final String JSON_STORE = "./data/listOfPatients.json";

    static final String ERCOORDINATOR = "Card for ER Coordinator";
    static final String NEWPATIENT = "Card for New Patients";

    private ListOfPatients erPatients;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    protected JButton loadButton;
    protected JButton saveButton;
    protected JButton addPatientButton;
    protected JButton assignButton;
    protected JButton removeButton;

    JPanel cards; //a panel that uses CardLayout

    public App() throws FileNotFoundException {
        erPatients = new ListOfPatients("ER Patients");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        Patient p1 = new Patient("troy");
        Patient p2 = new Patient("fred");
        erPatients.addPatient(p1);
        erPatients.addPatient(p2);
    }

    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
//        JPanel comboBoxPane = new JPanel(); //use FlowLayout
//        String comboBoxItems[] = {ERCOORDINATOR, NEWPATIENT};
//        JComboBox cb = new JComboBox(comboBoxItems);
//        cb.setEditable(false);
//        cb.addItemListener(this);
//        comboBoxPane.add(cb);

        addAddPatientButton();
//        addPatientButton = new JButton("Add Patient");
//        addPatientButton.setVerticalTextPosition(AbstractButton.CENTER);
//        addPatientButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
//        addPatientButton.setMnemonic(KeyEvent.VK_D);
//        addPatientButton.setActionCommand("Add Patient");

        //Create the "cards".
        PatientsTable card2 = new PatientsTable(erPatients);


//        NewPatient card1 = new NewPatient(erPatients);
//        card1.setLayout(new BoxLayout(card1, BoxLayout.PAGE_AXIS));


        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card2, ERCOORDINATOR);
//        cards.add(card1, NEWPATIENT);

        addLoadPatientButton();

        addSavePatientButton();

        addAssignPatientButton();

        addRemovePatientButton();

        addPatientButton.addActionListener(this);
        loadButton.addActionListener(this);
        saveButton.addActionListener(this);
        assignButton.addActionListener(this);
        removeButton.addActionListener(this);

        createButtonToolTips();

//        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
        pane.add(addPatientButton, BorderLayout.LINE_END);
        pane.add(loadButton, BorderLayout.AFTER_LAST_LINE);
        pane.add(saveButton, BorderLayout.LINE_START);
        pane.add(assignButton, BorderLayout.PAGE_START);
        pane.add(removeButton, BorderLayout.BEFORE_LINE_BEGINS);
    }

    public void addAddPatientButton() {
        addPatientButton = new JButton("Add Patient");
        addPatientButton.setVerticalTextPosition(AbstractButton.CENTER);
        addPatientButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        addPatientButton.setMnemonic(KeyEvent.VK_D);
        addPatientButton.setActionCommand("Add Patient");
    }

    public void addRemovePatientButton() {
        removeButton = new JButton("Remove Patient");
        removeButton.setVerticalTextPosition(AbstractButton.CENTER);
        removeButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        removeButton.setMnemonic(KeyEvent.VK_D);
        removeButton.setActionCommand("Remove Patient");
    }

    public void addAssignPatientButton() {
        assignButton = new JButton("Assign");
        assignButton.setVerticalTextPosition(AbstractButton.CENTER);
        assignButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        assignButton.setMnemonic(KeyEvent.VK_D);
        assignButton.setActionCommand("Assign");
    }

    public void addSavePatientButton() {
        saveButton = new JButton("Save");
        saveButton.setVerticalTextPosition(AbstractButton.CENTER);
        saveButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        saveButton.setMnemonic(KeyEvent.VK_D);
        saveButton.setActionCommand("Save");
    }

    public void addLoadPatientButton() {
        loadButton = new JButton("Load");
        loadButton.setVerticalTextPosition(AbstractButton.CENTER);
        loadButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        loadButton.setMnemonic(KeyEvent.VK_D);
        loadButton.setActionCommand("Load");
    }

    public void createButtonToolTips() {
        addPatientButton.setToolTipText("Click to add a patient to the list");
        removeButton.setToolTipText("Click to remove a patient from the list");
        saveButton.setToolTipText("Click to save list");
        loadButton.setToolTipText("Click to load list");
    }


    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }


    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() throws FileNotFoundException {

        try {

            //Create and set up the window.
            JFrame frame = new JFrame("CardLayoutDemo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Create and set up the content pane.
            App demo = new App();
            demo.addComponentToPane(frame.getContentPane());

            //Display the window.
            frame.pack();
            frame.setVisible(true);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to rune application: file not found");
        }
    }

    public static void main(String[] args) {


        //* Use an appropriate Look and Feel *//*
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
        //* Turn off metal's use of bold fonts *//*
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        if ("Add Patient".equals(ae.getActionCommand())) {
            doAddPatient();
        } else if ("Load".equals(ae.getActionCommand())) {
            try {
                erPatients = jsonReader.read();
                System.out.println("Loaded " + erPatients.getName() + " from " + JSON_STORE);
            } catch (IOException e) {
                System.out.println("Unable to read from file: " + JSON_STORE);
            }
        } else if ("Save".equals(ae.getActionCommand())) {
            try {
                jsonWriter.open();
                jsonWriter.write(erPatients);
                jsonWriter.close();
                System.out.println("Saved " + erPatients.getName() + " to " + JSON_STORE);
            } catch (FileNotFoundException e) {
                System.out.println("Unable to write to file: " + JSON_STORE);
            }
        } else if ("Assign".equals(ae.getActionCommand())) {
            doAssignPatient();
        } else if ("Remove Patient".equals(ae.getActionCommand())) {
            doRemovePatient();
        }
    }

    public void doAddPatient() {
        AddPatientDialog dlg = new AddPatientDialog(this);
        dlg.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        Patient results = dlg.run();
        System.out.println(results.getPatientName());
        erPatients.addPatient(results);
    }

    public void doRemovePatient() {
        RemovePatientDialog dlg = new RemovePatientDialog(this);
        dlg.setLayout(new FlowLayout());
        String[] results = dlg.run();
        erPatients.removePatient(erPatients.findPatient(results[0]));
    }

    public void doAssignPatient() {
        AssignPatientDialog dlg = new AssignPatientDialog(this);
        dlg.setLayout(new FlowLayout());
        String[] results = dlg.run();
        erPatients.findPatient(results[0]).setAssignment(results[1]);
    }
}