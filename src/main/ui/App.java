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

public class App implements ItemListener {
    private static final String JSON_STORE = "./data/listOfPatients.json";
    private Scanner input;
    private ListOfPatients erPatients;
    Patient p1;
    Patient p2;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    final static String ERCOORDINATOR = "Card for ER Coordinator";
    final static String NEWPATIENT = "Card for New Patients";
    JPanel cards; //a panel that uses CardLayout

    public App() throws FileNotFoundException {
        erPatients = new ListOfPatients("ER Patients");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        Patient p1 = new Patient("troy");
        erPatients.addPatient(p1);
        erPatients.addPatient(p1);
    }

    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = {ERCOORDINATOR, NEWPATIENT};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        //Create the "cards".
        PatientsTable card2 = new PatientsTable(erPatients);


        NewPatient card1 = new NewPatient(erPatients);
        card1.setLayout(new BoxLayout(card1, BoxLayout.PAGE_AXIS));


        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card2, ERCOORDINATOR);
        cards.add(card1, NEWPATIENT);


        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
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
}