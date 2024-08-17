/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author rodri
 */
public class Animal {
    //ATRIBUTOS = CARACTERISTICAS DEL OBJETO
    private String nombre;
    private int edad;
    
    //CONSTRUCTOR
    public Animal(String nombre) {
        this.nombre = nombre;
        this.edad = 0;
    }
    
    //ENCAPSULAMIENTO
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    //METODOS PERSONALIZADOS
    public String hablar(){
        return "No me identifico con un animal en especifico :c";
    }
}
