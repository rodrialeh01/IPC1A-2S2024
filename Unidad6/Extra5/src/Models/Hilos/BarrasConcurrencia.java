/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import Views.Ventana;
import javax.swing.JProgressBar;
import extra5.Extra5;


/**
 *
 * @author rodri
 */
public class BarrasConcurrencia extends Thread{
    int tiempo1;
    int tiempo2;
    int tiempo3;
    JProgressBar progreso1;
    JProgressBar progreso2;
    JProgressBar progreso3;
    Ventana v;

    public BarrasConcurrencia(int tiempo1, int tiempo2, int tiempo3, JProgressBar progreso1, JProgressBar progreso2, JProgressBar progreso3, Ventana v) {
        this.tiempo1 = tiempo1;
        this.tiempo2 = tiempo2;
        this.tiempo3 = tiempo3;
        this.progreso1 = progreso1;
        this.progreso2 = progreso2;
        this.progreso3 = progreso3;
        this.v = v;
    }
    
    @Override
    public void run(){
        try {
            HiloProgreso hilo1 = new HiloProgreso(this.progreso1,this.tiempo1);
            hilo1.start();
            hilo1.join(); //ESTO HACE QUE EL HILO ESTE EN SERIE Y HASTA QUE TERMINE EL HILO ACTUAL, EJECUTA OTRO
            HiloProgreso hilo2 = new HiloProgreso(this.progreso2,this.tiempo2);
            hilo2.start();
            hilo2.join();
            HiloProgreso hilo3 = new HiloProgreso(this.progreso3,this.tiempo3);
            hilo3.start();
            hilo3.join();
            
            if(this.v.cantidad == this.v.contador){
                this.v.t.detener();
                this.v.dispose();
                System.out.println("TIEMPO TOTAL: " + this.v.lcontador.getText());
                Extra5.resultado_final.setTiempo_total(this.v.lcontador.getText());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(BarrasConcurrencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
