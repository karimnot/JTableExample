/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import objetos.Alumno;

/**
 *
 * @author redoaxaca
 */
public class Controlador {
    
    private ArrayList<Alumno> alumnos;
    
    public Controlador(){
        alumnos = new ArrayList<>();
    }
    
    public void nuevoAlumno(Alumno nuevoAlumno){
        alumnos.add(nuevoAlumno);
    }
    
    public void eliminarAlumno(int inx){
        alumnos.remove(inx);
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    
    
}
