/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase7;

import Controller.BasicController;
import Controller.CalculadoraController;
import Models.Calculadora;
import Views.CalculadoraView;

/**
 *
 * @author rodri
 */
public class Clase7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CalculadoraView cv = new CalculadoraView();
        Calculadora c = new Calculadora();
        //CalculadoraController cc = new CalculadoraController(cv, c);
        BasicController bc = new BasicController(cv,c);
        bc.inicializar();
    }
    
}
