/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import objetos.Alumno;


/**
 *
 * @author redoaxaca
 */
public class AlumnosModel extends AbstractTableModel{
    
    private List alumnos;
    
    public AlumnosModel(List oAlumnos){
        alumnos = oAlumnos;
    }

    @Override
    public int getRowCount() {
        return alumnos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumno alumno = (Alumno)alumnos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return alumno.getNoControl();
            case 1:
                return alumno.getNombre();
            case 2:
                return alumno.getCarrera();
            case 3:
                return alumno.getPromedio();
            default:
                throw new AssertionError();
        }
    }
    
}
