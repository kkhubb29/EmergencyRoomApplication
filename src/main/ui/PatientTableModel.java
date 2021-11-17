package ui;

import model.ListOfPatients;
import model.Patient;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

// creates the model for the table of patients
public class PatientTableModel extends AbstractTableModel {

    private String[] columnNames = {"Name", "Assignment", "Score"};
    private ArrayList<Patient> myList;

    // EFFECTS: constructs the model for that table of patients for a list of patients
    public PatientTableModel(ListOfPatients patientList) {
        patientList.getListOfPatientsSorted();
        myList = patientList.getListOfPatients();
    }

    // EFFECTS: returns the number of columns
    public int getColumnCount() {
        return columnNames.length;
    }

    // EFFECTS: returns the number of rows, if the list is empty returns 0
    public int getRowCount() {
        int size;
        if (myList == null) {
            size = 0;
        } else {
            size = myList.size();
        }
        return size;
    }

    // REQUIRES: a row and column number within the bounds of the table
    // MODIFIES: this
    // EFFECTS: fills in the table
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

    // REQUIRES: a column number from within the bounds of the table
    // EFFECTS: returns the name of the column
    public String getColumnName(int col) {
        return columnNames[col];
    }

    // REQUIRES: a column number from within the bounds of the table
    // EFFECTS: returns the type of information in each column
    public Class getColumnClass(int col) {
        if (col == 2) {
            return Integer.class;
        } else {
            return String.class;
        }
    }

}
