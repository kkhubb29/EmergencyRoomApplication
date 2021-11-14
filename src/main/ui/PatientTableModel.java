package ui;

import model.ListOfPatients;
import model.Patient;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class PatientTableModel extends AbstractTableModel {

    private String[] columnNames = {"Name", "Assignment", "Score"};
    private ArrayList<Patient> myList;

    public PatientTableModel(ListOfPatients patientList) {
        myList = patientList.getListOfPatients();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        int size;
        if (myList == null) {
            size = 0;
        } else {
            size = myList.size();
        }
        return size;
    }

    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {
            temp = myList.get(row).getPatientName();
        } else if (col == 1) {
            temp = myList.get(row).getAssignment();
        } else if (col == 2) {
            temp = new Integer(myList.get(row).getScore());
        }
        return temp;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class getColumnClass(int col) {
        if (col == 2) {
            return Integer.class;
        } else {
            return String.class;
        }
    }

}
