package ui;

import model.ListOfPatients;

import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class PatientsTable extends JPanel {

    private PatientTableModel tableModel;
    private JTable table;
    private ListOfPatients myList;

    public PatientsTable(ListOfPatients lop) {
        this.myList = lop;
        setBounds(10, 10, 400, 300);
        tableModel = new PatientTableModel(myList);
        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(380, 280));
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        add(panel, BorderLayout.CENTER);
    }




}
