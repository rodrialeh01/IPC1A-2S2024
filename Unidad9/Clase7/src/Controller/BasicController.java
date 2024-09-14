/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Models.Calculadora;
import Views.CalculadoraView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author rodri
 */
public class BasicController implements ActionListener{
    CalculadoraView vista;
    Calculadora modelo;

    public BasicController(CalculadoraView vista, Calculadora modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void inicializar(){
        this.vista.setVisible(true);
        this.vista.jButton1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.vista.jButton1){
            this.boton5();
        }else if(e.getSource() == this.vista.jButton2){
            System.out.println("hola");
        }
    }

    
    public void boton5(){
        String texto_obtenido = this.vista.jTextField1.getText();
        this.vista.jTextField1.setText(texto_obtenido + "5");
    }
}
