package ui;

import com.sun.org.apache.bcel.internal.generic.InstructionListObserver;
import model.ListOfPatients;
import model.Patient;

import javax.swing.*;

import java.awt.event.*;

import static java.lang.Integer.parseInt;

public class NewPatient extends JPanel implements ActionListener {

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
    Patient p1;
    private ListOfPatients myList;

    public NewPatient(ListOfPatients lop) {
        this.myList = lop;

        nameLabel = new JLabel();
        nameLabel.setText("Name? ");

        ageLabel = new JLabel();
        ageLabel.setText("Age? ");

        painLabel = new JLabel();
        painLabel.setText("What is your pain level on a scale of 1-10? ");

        troubleBreathingButton = new JRadioButton("Are you having trouble breathing?");
        troubleBreathingButton.setVerticalTextPosition(AbstractButton.CENTER);
        troubleBreathingButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales

        chestPainButton = new JRadioButton("Are you experiencing chest pains?");
        chestPainButton.setVerticalTextPosition(AbstractButton.CENTER);
        chestPainButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales


        bleedingButton = new JRadioButton("Are you bleeding?");
        bleedingButton.setVerticalTextPosition(AbstractButton.CENTER);
        bleedingButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales

        nauseousButton = new JRadioButton("Are you nauseous?");
        nauseousButton.setVerticalTextPosition(AbstractButton.CENTER);
        nauseousButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales

        headInjuryButton = new JRadioButton("Do you have a head injury?");
        headInjuryButton.setVerticalTextPosition(AbstractButton.CENTER);
        headInjuryButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales


        pregnantButton = new JRadioButton("Are you pregnant?");
        pregnantButton.setVerticalTextPosition(AbstractButton.CENTER);
        pregnantButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales


        nameField = new JTextField(20);
        textArea = new JTextArea(1, 20);
        textArea.setEditable(true);

        ageField = new JTextField(20);
        textArea = new JTextArea(1, 20);
        textArea.setEditable(true);


        painField = new JTextField(20);
        textArea = new JTextArea(1, 20);
        textArea.setEditable(true);

        submitButton = new JButton("Submit");
        submitButton.setVerticalTextPosition(AbstractButton.CENTER);
        submitButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        submitButton.setActionCommand("Submit");

        submitButton.addActionListener(this);

        troubleBreathingButton.setToolTipText("Click this button if you are the ER Coordinator.");

        //Add Components to this container, using the default FlowLayout.
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
            myList.addPatient(p1);
        }
        returnListOfPatients();
    }

    public ListOfPatients returnListOfPatients() {
        return myList;
    }

}

