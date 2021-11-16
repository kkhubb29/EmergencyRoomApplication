package ui;

import model.ListOfPatients;

import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

// creates the table that will be populated with information from the list of patients
public class PatientsTable extends JPanel {

    private PatientTableModel tableModel;
    private JTable table;
    private ListOfPatients myList;

    //EFFECTS: constructs a table
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

    public void fireTableDataChanged() {
        tableModel.fireTableDataChanged();
    }




}
