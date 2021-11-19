package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

// creates the remove patient dialog to remove a patient from the list of patients
public class RemovePatientDialog extends JDialog implements ActionListener {

    protected JButton removeButton;
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

        createRemoveButton();

        removeButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(removeButton);

        this.add(panel);
    }

    // EFFECTS: builds remove button
    public void createRemoveButton() {
        removeButton = new JButton("Remove");
        removeButton.setVerticalTextPosition(AbstractButton.CENTER);
        removeButton.setHorizontalTextPosition(AbstractButton.LEADING);
        removeButton.setMnemonic(KeyEvent.VK_R);
        removeButton.setActionCommand("Submit");
    }

    // REQUIRES: the user to click the remove button
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
        this.pack();
        this.setVisible(true);
        return data;
    }

}