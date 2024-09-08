/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package extra5;

/**
 *
 * @author rodri
 */
import Models.Hilos.Timer;
import Models.Resultados;
import Views.Ventana;
public class Extra5 {

    /**
     * @param args the command line arguments
     */
    
    public static Resultados resultado_final = new Resultados();
    
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        //CREANDO MI PRIMER HILO
        /*
        Timer hilo1 = new Timer();
        //COMENZAMOS EL HILO CON EL MÉTODO START()
        hilo1.start();
        hilo1.detener();
        */
        /*
        Producto p = Extra5.obtenerProducto(codigo);
        int tiempo1 = 0;
        
        if(p.getMaterial().toUpperCase() == "METAL"){
            tiempo1 = 15;
        }else if(p.getMaterial().toUpperCase() == "MADERA"){
            tiempo1 = 25;
        }
        
        int tiempo2 = 0;
        if(p.getColor().toUpperCase() == "VERDE"){
            tiempo1 = 15;
        }else if(p.getColor().toUpperCase() == "ROJO"){
            tiempo1 = 25;
        }
        
        int tiempo3 = 10;
        Ventana v = new Ventana(tiempo1,tiempo2,tiempo3,cantidad);
        
        hOlA == HOLA FALSE
        hOlA.toUpperCase() == HOLA TRUE
        */
        Ventana v = new Ventana(3,4,5,2);
    }
    
}
