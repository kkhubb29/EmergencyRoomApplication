package ui;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ERPatients extends JPanel
        implements ActionListener {
    protected JButton b1, b2;

    public ERPatients() {

        b1 = new JButton("Kairltb");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("ER Coordinator Selected");

        b2 = new JButton("New Patient");
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);
        b2.setActionCommand("New Patient Selected");

        //Listen for actions on buttons 1 and 3.
        b1.addActionListener(this);
        b2.addActionListener(this);

        b1.setToolTipText("Click this button if you are the ER Coordinator.");
        b2.setToolTipText("Click this button if you are a new patient.");

        //Add Components to this container, using the default FlowLayout.
        add(b1);
        add(b2);
    }

    public void actionPerformed(ActionEvent e) {
        if ("ER Coordinator Selected".equals(e.getActionCommand())) {
            System.out.println("ER button pushed");
        } else if ("New Patient Selected".equals(e.getActionCommand())) {
            System.out.println("New Patient button pushed");
        }
    }
}

