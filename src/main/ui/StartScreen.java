package ui;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class StartScreen extends JPanel
        implements ActionListener {
    protected JButton b1, b2, b3;

    public StartScreen() {

        b1 = new JButton("ER Coordinator");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("ER Coordinator Selected");

        b2 = new JButton("New Patient");
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);
        b2.setActionCommand("New Patient Selected");

        b3 = new JButton("Hide Panel");
        b3.setVerticalTextPosition(AbstractButton.BOTTOM);
        b3.setHorizontalTextPosition(AbstractButton.CENTER);
        b3.setMnemonic(KeyEvent.VK_M);
        b3.setActionCommand("Hide Panel");


        //Listen for actions on buttons 1 and 3.
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        b1.setToolTipText("Click this button if you are the ER Coordinator.");
        b2.setToolTipText("Click this button if you are a new patient.");

        //Add Components to this container, using the default FlowLayout.
        add(b1);
        add(b2);
        add(b3);
    }

    public void actionPerformed(ActionEvent e) {
        if ("ER Coordinator Selected".equals(e.getActionCommand())) {
            System.out.println("ER button pushed");
        } else if ("New Patient Selected".equals(e.getActionCommand())) {
            System.out.println("New Patient button pushed");
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame erApplication = new JFrame("ER Application");
        erApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        ERPatients newContentPane = new ERPatients();
        newContentPane.setOpaque(true); //content panes must be opaque
        erApplication.setContentPane(newContentPane);

        //Display the window.
        erApplication.pack();
        erApplication.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

