/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author rodri
 */
import Models.Calculadora;
import java.util.LinkedList;


public class CalculosController {
    static LinkedList<Calculadora> calculos = new LinkedList<Calculadora>();
    
    public static void insertar(Calculadora c){
        calculos.add(c);
    }
    
    public static void editar(int numero1, int numero2, String operacion){
        for (int i = 0; i < calculos.size(); i++) {
            if (operacion.equals(calculos.get(i).getOperacion())) {
                calculos.get(i).setNumero1(numero1);
                calculos.get(i).setNumero2(numero2);
            }
        }
    }
}
