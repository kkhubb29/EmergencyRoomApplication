package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

// creates the load patients dialog
public class StartLoadDialog extends JDialog implements ActionListener {
    protected JButton yesButton;
    protected JButton noButton;
    protected JLabel questionLabel;

    private boolean load;

    // EFFECTS: constructs the load patients dialog
    public StartLoadDialog(Frame parent) {
        super(parent, "Load Patients", true);
        this.setPreferredSize(new Dimension(500,90));

        load = false;

        questionLabel = new JLabel();
        questionLabel.setText("Would you like to load existing patients?");

        createYestButton();

        createNoButton();

        JPanel buttons = new JPanel();
        buttons.add(yesButton);
        buttons.add(noButton);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(questionLabel);
        panel.add(buttons);

        this.add(panel);
    }

    // EFFECTS: builds yes button
    public void createYestButton() {
        yesButton = new JButton("Yes");
        yesButton.setVerticalTextPosition(AbstractButton.CENTER);
        yesButton.setHorizontalTextPosition(AbstractButton.LEADING);
        yesButton.setMnemonic(KeyEvent.VK_Y);
        yesButton.setActionCommand("Load");
        yesButton.addActionListener(this);
    }

    // EFFECTS: builds no button
    public void createNoButton() {
        noButton = new JButton("No");
        noButton.setVerticalTextPosition(AbstractButton.CENTER);
        noButton.setHorizontalTextPosition(AbstractButton.LEADING);
        noButton.setMnemonic(KeyEvent.VK_N);
        noButton.setActionCommand("Cancel");
        noButton.addActionListener(this);
    }

    // REQUIRES: the user to click the yes button
    // EFFECTS: stores the answers to the questions and closes the window
    public void actionPerformed(ActionEvent e) {
        if ("Load".equals(e.getActionCommand())) {
            load = true;
        }
        dispose();
    }

    // EFFECTS: displays the load patients? dialog and returns the answer
    public boolean run() {
        this.pack();
        this.setVisible(true);
        return load;
    }

}