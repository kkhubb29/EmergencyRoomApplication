package ui;

import javax.swing.JOptionPane; //imports
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Dimension;

public class PopUpImage {

    public PopUpImage() {
        JFrame f = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setUndecorated(true);
        ImageIcon image = new ImageIcon("IMAGEURL.jpg");
        JLabel lbl = new JLabel(image);
        f.getContentPane().add(lbl);
        f.setSize(image.getIconWidth(), image.getIconHeight());

        int x = (screenSize.width - f.getSize().width) / 2;
        int y = (screenSize.height - f.getSize().height) / 2;

        f.setLocation(x, y);
        f.setVisible(true);
    }


    public static void main(String[] args){
        JFrame f = new JFrame(); //creates jframe f

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //this is your screen size

        f.setUndecorated(true); //removes the surrounding border

        ImageIcon image = new ImageIcon("thumbsup.jpg"); //imports the image

        JLabel lbl = new JLabel(image); //puts the image into a jlabel

        f.getContentPane().add(lbl); //puts label inside the jframe

        f.setSize(image.getIconWidth(), image.getIconHeight()); //gets h and w of image and sets jframe to the size

        int x = (screenSize.width - f.getSize().width)/2; //These two lines are the dimensions
        int y = (screenSize.height - f.getSize().height)/2;//of the center of the screen

        f.setLocation(x, y); //sets the location of the jframe
        f.setVisible(true); //makes the jframe visible
    }
}