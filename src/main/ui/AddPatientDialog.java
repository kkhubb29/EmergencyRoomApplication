package ui;

import model.ListOfPatients;
import model.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static java.lang.Integer.parseInt;

// creates the patient questionnaire to add a patient
public class AddPatientDialog extends JDialog implements ActionListener {

    protected JButton submitButton;
    protected JRadioButton troubleBreathingButton;
    protected JRadioButton chestPainButton;
    protected JRadioButton bleedingButton;
    protected JRadioButton nauseousButton;
    protected JRadioButton headInjuryButton;
    protected JRadioButton pregnantButton;
    protected JTextField nameField;
    protected JTextField ageField;
    protected JTextField painField;
    protected JTextArea textArea;
    protected JLabel nameLabel;
    protected JLabel ageLabel;
    protected JLabel painLabel;

    private Patient p1;

    // EFFECTS: constructs the add patient dialog
    public AddPatientDialog(Frame parent) {
        super(parent, "Add Patient", true);

        createLabels();
        createFields();

        createTroubleBreathingButton();
        createChestPainButton();
        createBleedingButton();
        createNauseousButton();
        createHeadInjuryButton();
        createPregnantButton();

        createSubmitButton();

        submitButton.addActionListener(this);

        createToolTips();

        //Add Components to this container, using the default FlowLayout.

        //      JPanel panel = new JPanel(new SpringLayout());
//       panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        buildQuestionnaire();


    }

    // EFFECTS: builds the trouble breathing radio button
    public void createTroubleBreathingButton() {
        troubleBreathingButton = new JRadioButton("Are you having trouble breathing?");
        troubleBreathingButton.setVerticalTextPosition(AbstractButton.CENTER);
        troubleBreathingButton.setHorizontalTextPosition(AbstractButton.LEADING);
    }

    // EFFECTS: builds the chest pain radio button
    public void createChestPainButton() {
        chestPainButton = new JRadioButton("Are you experiencing chest pains?");
        chestPainButton.setVerticalTextPosition(AbstractButton.CENTER);
        chestPainButton.setHorizontalTextPosition(AbstractButton.LEADING);
    }

    // EFFECTS: builds the bleeding radio button
    public void createBleedingButton() {
        bleedingButton = new JRadioButton("Are you bleeding?");
        bleedingButton.setVerticalTextPosition(AbstractButton.CENTER);
        bleedingButton.setHorizontalTextPosition(AbstractButton.LEADING);
    }

    // EFFECTS: builds the nauseous radio button
    public void createNauseousButton() {
        nauseousButton = new JRadioButton("Are you nauseous?");
        nauseousButton.setVerticalTextPosition(AbstractButton.CENTER);
        nauseousButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
    }

    // EFFECTS: builds the head injury radio button
    public void createHeadInjuryButton() {
        headInjuryButton = new JRadioButton("Do you have a head injury?");
        headInjuryButton.setVerticalTextPosition(AbstractButton.CENTER);
        headInjuryButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
    }

    // EFFECTS: builds the pregnant radio button
    public void createPregnantButton() {
        pregnantButton = new JRadioButton("Are you pregnant?");
        pregnantButton.setVerticalTextPosition(AbstractButton.CENTER);
        pregnantButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
    }

    // EFFECTS: builds the text labels for the name, age, and pain level questions
    public void createLabels() {
        nameLabel = new JLabel();
        nameLabel.setText("Name? ");

        ageLabel = new JLabel();
        ageLabel.setText("Age? ");

        painLabel = new JLabel();
        painLabel.setText("What is your pain level on a scale of 1-10? ");
    }

    // EFFECTS: builds the text entry boxes for the name, age, and pain level questions
    public void createFields() {
        nameField = new JTextField(20);
        textArea = new JTextArea(1, 20);
        textArea.setEditable(true);

        ageField = new JTextField(20);
        textArea = new JTextArea(1, 20);
        textArea.setEditable(true);


        painField = new JTextField(20);
        textArea = new JTextArea(1, 20);
        textArea.setEditable(true);
    }

    // EFFECTS: builds the submit button
    public void createSubmitButton() {
        submitButton = new JButton("Submit");
        submitButton.setVerticalTextPosition(AbstractButton.CENTER);
        submitButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        submitButton.setActionCommand("Submit");
    }

    // EFFECTS: builds text that appears when user hovers over buttons
    public void createToolTips() {
        troubleBreathingButton.setToolTipText("Select if you are having trouble breathing");
        chestPainButton.setToolTipText("Select if you are experiencing chest pains");
        bleedingButton.setToolTipText("Select if you are bleeding");
        nauseousButton.setToolTipText("Select if you are nauseous");
        headInjuryButton.setToolTipText("Select if you have a head injury");
        pregnantButton.setToolTipText("Select if you are pregnant");
        submitButton.setToolTipText("Click to submit questionnaire");
    }

    // EFFECTS: adds the buttons, fields, and labels to the screen
    public void buildQuestionnaire() {
        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(painLabel);
        add(painField);
        add(troubleBreathingButton);
        add(chestPainButton);
        add(bleedingButton);
        add(nauseousButton);
        add(headInjuryButton);
        add(pregnantButton);
        add(submitButton);
    }

    // REQUIRES: the user to click the submit button
    // EFFECTS: creates a patient based on the answers to the questionnaire and closes the questionnaire
    @SuppressWarnings("methodlength")
    public void actionPerformed(ActionEvent e) {
        if ("Submit".equals(e.getActionCommand())) {
            String nameText = nameField.getText();
            p1 = new Patient(nameText);
            String ageText = ageField.getText();
            p1.setAge(parseInt(ageText));
            String painText = painField.getText();
            p1.setPain(parseInt(painText));
            if (troubleBreathingButton.isSelected()) {
                p1.setTroubleBreathing("y");
            } else {
                p1.setTroubleBreathing("n");
            }
            if (chestPainButton.isSelected()) {
                p1.setChestPain("y");
            } else {
                p1.setChestPain("n");
            }
            if (bleedingButton.isSelected()) {
                p1.setBleeding("y");
            } else {
                p1.setBleeding("n");
            }
            if (nauseousButton.isSelected()) {
                p1.setNauseous("y");
            } else {
                p1.setNauseous("n");
            }
            if (headInjuryButton.isSelected()) {
                p1.setHeadInjury("y");
            } else {
                p1.setHeadInjury("n");
            }
            if (pregnantButton.isSelected()) {
                p1.setPregnant("y");
            } else {
                p1.setPregnant("n");
            }
            p1.setScore(p1.calculateScore());
        }
        dispose();
    }

    // EFFECTS: displays the questionnaire and returns the new patient
    public Patient run() {
        this.setVisible(true);
        return p1;
    }
}



