package ui;

import model.ListOfPatients;
import model.Patient;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Scanner;


public class ERPatientsTable extends JPanel {

    public ERPatientsTable(ListOfPatients lopp) {
        super(new GridLayout(1, 0));

        JTable table = new JTable(new MyTableModel(lopp));
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    class MyTableModel extends AbstractTableModel {

        private ListOfPatients lopp;
        private Object[][] data = getTableData();
        private String[] columnNames = {"Name",
                "Score",
                "Assignment"};

        public MyTableModel(ListOfPatients lopp) {
            this.lopp = lopp;
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        public Object[][] getTableData()  {
            lopp.getListOfPatientsSorted();
            ArrayList<Patient> patientsList = lopp.getListOfPatients();

            if (patientsList.size() == 0) {
                System.out.println("there are no patients");

                String col1row1 = "col1row1";
                String col2row1 = "col2row1";
                String col3row1 = "col3row1";

                Object[][] patientData = {
                        {col1row1, col2row1, col3row1}
                };

                return patientData;

            } else {
                for (int i = 0; i < patientsList.size(); i++) {
                    String col1row1 = patientsList.get(i).getPatientName();
                    String col2row1 = patientsList.get(i).getAssignment();
                    int col3row1 = patientsList.get(i).getScore();

                    Object[][] patientData = {
                            {col1row1, col2row1, new Integer(col3row1)}
                    };

                    return patientData;

                }

            }

            return new Object[0][];
        }


        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 3) {
                return false;
            } else {
                return true;
            }
        }


    }
}