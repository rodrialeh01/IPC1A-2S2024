/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.event.ActionListener;

/**
 *
 * @author rodri
 */
import Clases.Analista;
import clase6.Clase6;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VEliminarAnalista extends JFrame implements ActionListener{
    JLabel titulo, lcodigo;
    JTextField tcodigo;
    JButton beliminar, bregresar;
    String codigot;
    public VEliminarAnalista() {
        //TITULO
        titulo = new JLabel("Eliminar Analista");
        titulo.setFont(new Font("Century Gothic",Font.BOLD,15));
        titulo.setBounds(120,30,250,30);
        titulo.setVisible(true);
        this.add(titulo);
        
        //label de codigo
        lcodigo = new JLabel("Codigo: ");
        lcodigo.setFont(new Font("Century Gothic",Font.BOLD,18));
        lcodigo.setBounds(40,100,100,30);
        lcodigo.setVisible(true);
        this.add(lcodigo);
        
        //BOTON REGRESAR
        bregresar = new JButton("Regresar");
        bregresar.setBounds(100,450,280,40);
        bregresar.addActionListener(this);
        //BLOQUEAR UN BOTON
        //beliminar.setEnabled(false);
        this.add(bregresar);
        
        //BOTON ELIMINAR ANALISTA
        beliminar = new JButton("Eliminar Analista");
        beliminar.setBounds(100,500,280,40);
        beliminar.addActionListener(this);
        //BLOQUEAR UN BOTON
        //beliminar.setEnabled(false);
        this.add(beliminar);
        
        //TEXTFIELD DE CODIGO
        tcodigo = new JTextField();
        tcodigo.setBounds(140,100,100,30);
        tcodigo.setFont(new Font("Century Gothic",Font.PLAIN,18));
        tcodigo.setVisible(true);
        this.add(tcodigo);
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Eliminar Curso");
        this.setBounds(450, 100, 500, 600);
        this.getContentPane().setBackground(Color.YELLOW);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        codigot = tcodigo.getText();
        if (e.getSource() == beliminar) {
            Analista encontrado = Clase6.obtenerAnalista(codigot);
            
            if(encontrado != null){
                Clase6.eliminarAnalista(codigot);
                JOptionPane.showMessageDialog(this, "Analista eliminado correctamente");
                this.dispose();
                //ABRA EL VENTANAADMIN
                VentanaAdmin va = new VentanaAdmin();
            }else{
                JOptionPane.showMessageDialog(this, "No se encontro el analista");
            }
        }else if(e.getSource() == bregresar){
            //DESTRUIR LA VENTANA ACTUAL
            this.dispose();
            //ABRA EL VENTANAADMIN
            VentanaAdmin va = new VentanaAdmin();
        }
    }
}
