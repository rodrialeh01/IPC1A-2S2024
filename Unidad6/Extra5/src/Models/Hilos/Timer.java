/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author rodri
 */
public class Timer extends Thread{
    int segundos;
    int minutos;
    JLabel label;
    private volatile boolean ejecutando = true; 

    public Timer(JLabel label) {
        this.segundos = 0;
        this.minutos = 0;
        this.label = label;
    }
    
    @Override
    public void run(){
        try {
            while(ejecutando){
                if(this.segundos < 10){
                    //MINUTO:0SEGUNDOS
                    //0:05
                    //0:08
                    //System.out.println(this.minutos + ":0" + this.segundos);
                    label.setText(this.minutos+ ":0"+ this.segundos);
                }else{
                    //System.out.println(this.minutos + ":"+ this.segundos);
                    label.setText(this.minutos+ ":"+ this.segundos);
                }
                label.repaint();
                //SLEEP: PAUSA EN MILISEGUNDOS
                Thread.sleep(1000);
                this.segundos++;
                if(this.segundos == 60){
                    this.minutos++;
                    this.segundos = 0;
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void detener(){
        this.ejecutando = false;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    
    
}
