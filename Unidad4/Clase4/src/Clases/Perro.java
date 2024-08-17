/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author rodri
 */
//PARA APLICAR HERENCIA USAMOS EXTENDS
public class Perro extends Animal{
    
    public Perro() {
        super("perro");
    }
    
    //POLIMORFISMO
    public String hablar(){
        return "guau";
    }
    
}
