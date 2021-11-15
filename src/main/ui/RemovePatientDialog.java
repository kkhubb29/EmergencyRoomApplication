package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// creates the remove patient dialog to remove a patient from the list of patients
public class RemovePatientDialog extends JDialog implements ActionListener {

    protected JButton submitButton;
    protected JTextField nameField;
    protected JTextArea textArea;
    protected JLabel nameLabel;

    private String[] data;

    // EFFECTS: constructs the remove patient dialog
    public RemovePatientDialog(Frame parent) {
        super(parent, "Remove Patient", true);

        data = new String[1];

        nameLabel = new JLabel();
        nameLabel.setText("What is the name of the patient you would like to remove from the list? ");

        nameField = new JTextField(20);
        textArea = new JTextArea(1, 20);
        textArea.setEditable(true);

        submitButton = new JButton("Submit");
        submitButton.setVerticalTextPosition(AbstractButton.CENTER);
        submitButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        submitButton.setActionCommand("Submit");

        submitButton.addActionListener(this);

        add(nameLabel);
        add(nameField);
        add(submitButton);
    }

    // REQUIRES: the user to click the submit button
    // EFFECTS: stores the answer to the question and closes the window
    public void actionPerformed(ActionEvent e) {
        if ("Submit".equals(e.getActionCommand())) {
            String nameText = nameField.getText();
            data[0] = nameText;
        }
        dispose();
    }

    // EFFECTS: displays the remove patient questions and returns the answer to the question
    public String[] run() {
        this.setVisible(true);
        return data;
    }

}
