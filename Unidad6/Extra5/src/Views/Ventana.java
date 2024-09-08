/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import javax.swing.*;

/**
 *
 * @author rodri
 */
import javax.swing.*;
import Models.Hilos.Timer;
import Models.Hilos.BarrasConcurrencia;
import java.awt.*;
import extra5.Extra5;
public class Ventana extends JFrame{
    JProgressBar progreso1, progreso2, progreso3;
    public JLabel lcontador, lcontador2;
    public Timer t;
    int tiempo1;
    int tiempo2;
    int tiempo3;
    public int cantidad;
    public int contador = 1;
    public Ventana(int tiempo1, int tiempo2, int tiempo3, int cantidad) throws InterruptedException {
        this.tiempo1 = tiempo1;
        this.tiempo2 = tiempo2;
        this.tiempo3 = tiempo3;
        this.cantidad = cantidad;
        
        
        //BARRA DE PROGRESO 1
        progreso1 = new JProgressBar(0,100);
        progreso1.setStringPainted(true);
        progreso1.setBounds(15,20,550,30);
        this.add(progreso1);
        
        //BARRA DE PROGRESO 2
        progreso2 = new JProgressBar(0,100);
        progreso2.setStringPainted(true);
        progreso2.setBounds(25,70,550,30);
        this.add(progreso2);
        
        //BARRA DE PROGRESO 3
        progreso3 = new JProgressBar(0,100);
        progreso3.setStringPainted(true);
        progreso3.setBounds(25,120,550,30);
        this.add(progreso3);
        
        lcontador = new JLabel("0:00");
        lcontador.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lcontador.setBounds(180,200,100,30);
        lcontador.setVisible(true);
        this.add(lcontador);
        
        lcontador2 = new JLabel(this.contador+"/"+ this.cantidad);
        lcontador2.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lcontador2.setBounds(260,200,100,30);
        lcontador2.setVisible(true);
        this.add(lcontador2);
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Hilos");
        this.setBounds(400, 200, 600, 400);
        this.getContentPane().setBackground(Color.cyan);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        t = new Timer(lcontador);
        t.start();
        
        while(this.contador <= this.cantidad){
            BarrasConcurrencia bc = new BarrasConcurrencia(this.tiempo1,this.tiempo2,this.tiempo3,progreso1,progreso2,progreso3, this);
            progreso1.setValue(0);
            progreso2.setValue(0);
            progreso3.setValue(0);
            bc.start();
            bc.join();
            if(this.contador == 1){
                Extra5.resultado_final.setTiempo_unico(lcontador.getText());
                System.out.println("EL TIEMPO DE 1 PRODUCTO ES: "+ lcontador.getText());
            }
            this.contador++;
            lcontador2.setText(this.contador+"/"+this.cantidad);
            this.repaint();
        }
    }
    
}
