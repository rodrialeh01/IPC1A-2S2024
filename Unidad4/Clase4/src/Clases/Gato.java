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
public class Gato extends Animal{
    
    private String[][] comidas;
    
    public Gato() {
        //new Animal(NOMBRE);
        //super()
        super("gato");
    }
    
    //POLIMORFISMO
    public String hablar(){
        return "miau";
    }

    /**
     * @return the comidas
     */
    public String[][] getComidas() {
        return comidas;
    }

    /**
     * @param comidas the comidas to set
     */
    public void setComidas(String[][] comidas) {
        this.comidas = comidas;
    }
    
    
}
