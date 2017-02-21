/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.AlumnosModel;
import controller.Controlador;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import objetos.Alumno;

/**
 *
 * @author redoaxaca
 */
public class PrincipalForm extends JFrame {
    
    private JTable tblAlumnos;
    private JPanel pnlEncabezado;
    private JPanel pnlBotones;
    
    private Controlador controlador;
    private AlumnosModel alumnoModel;
    
    private AlumnosDialog dlgAlumnos;
    
    private JButton btnNuevo;
    private JButton btnEliminar;
    private JButton btnCerrar;
    
    public PrincipalForm(){
        super("JTable Example - Alumnos");
        super.setSize(600, 400);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        
        // *** Objetos *** //
        
        controlador = new Controlador();
        alumnoModel = new AlumnosModel(controlador.getAlumnos());
        tblAlumnos = new JTable(alumnoModel);
        
        dlgAlumnos = new AlumnosDialog(this);
        dlgAlumnos.setListener(new AlumnosDialogListener() {
            @Override
            public void aceptarButtonClick(Alumno alumno) {
                controlador.nuevoAlumno(alumno);
                alumnoModel.fireTableDataChanged();
            }
        });
        
        // *** EncabezadoPanel ***
        pnlEncabezado = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlEncabezado.add(new JLabel("Listado de Alumnos"));
        
        // *** BotonesPanel ***

        pnlBotones = new JPanel(new BorderLayout());
        
        JPanel pnlCerrar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnCerrar = new JButton("Salir");
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        pnlCerrar.add(btnCerrar);
        
        JPanel pnlAcciones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnNuevo = new JButton("Nuevo");
        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlgAlumnos.mostrar();
            }
        });
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowSelected = tblAlumnos.getSelectedRow();
                if (rowSelected >= 0){
                    controlador.eliminarAlumno(rowSelected);
                    alumnoModel.fireTableDataChanged();
                }
            }
        });
        pnlAcciones.add(btnNuevo);
        pnlAcciones.add(btnEliminar);
        
        pnlBotones.add(pnlCerrar, BorderLayout.WEST);
        pnlBotones.add(pnlAcciones, BorderLayout.EAST);        
        
        // *** Agregamos al Frame
        
        super.add(pnlEncabezado, BorderLayout.NORTH);
        super.add(pnlBotones, BorderLayout.SOUTH);
        super.add(new JScrollPane(tblAlumnos), BorderLayout.CENTER);
        
        super.setVisible(true);
    }
    
}
