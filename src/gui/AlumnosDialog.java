/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import objetos.Alumno;
import objetos.Carrera;

/**
 *
 * @author redoaxaca
 */
public class AlumnosDialog extends JDialog {
    
    private AlumnosDialogListener listener;
    
    private JTextField edtNoControl;
    private JTextField edtNombre;
    private JTextField edtPromedio;
    private JComboBox<Carrera> cmbCarrera;
    
    public AlumnosDialog(JFrame owner){
        super(owner, true);
        super.setLayout(new BorderLayout());
        super.setSize(250, 200);
        
        JPanel pnlBotoncitos = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Alumno alumno = new Alumno(edtNoControl.getText(), edtNombre.getText(), (Carrera)cmbCarrera.getSelectedItem(), Float.valueOf(edtPromedio.getText()));
                listener.aceptarButtonClick(alumno);
                setVisible(false);
            }
        });
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        
        pnlBotoncitos.add(btnAceptar);
        pnlBotoncitos.add(btnCancelar);   
        
        JPanel pnlControles = new JPanel();
       

        edtNoControl = new JTextField(10);
        edtNombre = new JTextField(10);
        edtPromedio = new JTextField(10);
        cmbCarrera = new JComboBox<>(Carrera.values());
        
        pnlControles.add(new JLabel("No. Control: "));
        pnlControles.add(edtNoControl);      
        
        pnlControles.add(new JLabel("Nombre: "));
        pnlControles.add(edtNombre);
        
        pnlControles.add(new JLabel("Carrera: "));
        pnlControles.add(cmbCarrera);
        
        pnlControles.add(new JLabel("Calificacion: "));
        pnlControles.add(edtPromedio);
        
        
        
        super.add(pnlBotoncitos, BorderLayout.SOUTH);
        super.add(pnlControles);
    }

    public void setListener(AlumnosDialogListener listener) {
        this.listener = listener;
    }
    
    public void mostrar(){
        edtNoControl.setText("");
        edtNombre.setText("");
        edtPromedio.setText("");
        cmbCarrera.setSelectedIndex(0);
        setVisible(true);
    }
    

    
}
