package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// creates the assign patient dialog to change the assignment of a patient from the list of patients
public class AssignPatientDialog extends JDialog implements ActionListener {
    protected JButton submitButton;
    protected JTextField nameField;
    protected JTextField assignField;
    protected JTextArea textArea;
    protected JLabel nameLabel;
    protected JLabel assignLabel;

    private String[] data;

    // EFFECTS: constructs the assign patient dialog
    public AssignPatientDialog(Frame parent) {
        super(parent, "Assign Patient", true);


        data = new String[2];

        createLabels();

        createFields();

        submitButton = new JButton("Submit");
        submitButton.setVerticalTextPosition(AbstractButton.CENTER);
        submitButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        submitButton.setActionCommand("Submit");

        submitButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(assignLabel);
        panel.add(assignField);
        panel.add(submitButton);

        this.add(panel);

    }

    // EFFECTS: builds labels for name and assignment questions
    public void createLabels() {
        nameLabel = new JLabel();
        nameLabel.setText("What is the name of the patient you would like to assign? ");

        assignLabel = new JLabel();
        assignLabel.setText("Where would you like to assign this patient?");
    }

    // EFFECTS: builds fields to enter text in for name and assignment question
    public void createFields() {
        nameField = new JTextField(20);
        textArea = new JTextArea(1, 20);
        textArea.setEditable(true);

        assignField = new JTextField(20);
        textArea = new JTextArea(1, 20);
        textArea.setEditable(true);
    }

    // REQUIRES: the user to click the submit button
    // EFFECTS: stores the answers to the questions and closes the window
    public void actionPerformed(ActionEvent e) {
        if ("Submit".equals(e.getActionCommand())) {
            String nameText = nameField.getText();
            String assignText = assignField.getText();
            data[0] = nameText;
            data[1] = assignText;
        }
        dispose();
    }

    // EFFECTS: displays the assign patient questions and returns the answers to the questions
    public String[] run() {
        this.pack();
        this.setVisible(true);
        return data;
    }


}