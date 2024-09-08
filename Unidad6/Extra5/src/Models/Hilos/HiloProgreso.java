/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author rodri
 */
public class HiloProgreso extends Thread{
    private JProgressBar barra;
    private int tiempo;

    public HiloProgreso(JProgressBar barra, int tiempo) {
        this.barra = barra;
        this.tiempo = tiempo;
    }

    @Override
    public void run(){
        int pasos = this.tiempo;
        int incremento = 100/pasos;
        try {
            for (int i = 0; i < pasos; i++) {
                int progreso = barra.getValue();
                barra.setValue(progreso+incremento);
                Thread.sleep(1000);
            }
            
            barra.setValue(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloProgreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @return the barra
     */
    public JProgressBar getBarra() {
        return barra;
    }

    /**
     * @param barra the barra to set
     */
    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    /**
     * @return the tiempo
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    
}
