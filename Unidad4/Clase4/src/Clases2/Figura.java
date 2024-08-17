/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases2;

/**
 *
 * @author rodri
 */
public abstract class Figura {
    protected int lados;
    
    public Figura(int lados){
        this.lados = lados;
    }
    
    public abstract double Area();
}
